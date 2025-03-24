package com.example.rest_practice.Service;

import com.example.rest_practice.Dto.Request.Member.CustomUserDetails;
import com.example.rest_practice.Entity.Member;
import com.example.rest_practice.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);
        if(member != null){
            return new CustomUserDetails(member);
        }
        return null;
    }
}
