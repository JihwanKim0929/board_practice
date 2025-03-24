package com.example.rest_practice.Jwt;

import com.example.rest_practice.Dto.Request.Member.CustomUserDetails;
import com.example.rest_practice.Entity.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith("Bearer ")){
            System.out.println("token null");

            //request와 response를 다음 필터로 넘겨줌
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorization.split(" ")[1];

        //토큰 소멸시간 검증
        if(jwtUtil.isExpired(token)){
            System.out.println("token expired");
            filterChain.doFilter(request,response);
            return;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        //DB에서 유저 찾아와도 되는데 매 호출마다 불러오면 효율성 안좋음. 그냥 직접 만들고 password에는 임시 비밀번호 삽입
        Member member = Member.builder()
                .username(username)
                .password("tempPassword")
                .role(role)
                .build();

        CustomUserDetails customUserDetails = new CustomUserDetails(member);
        //스프링 시큐리티 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails,null,customUserDetails.getAuthorities());
        //세션에 사용자 등록
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request,response);
    }
}
