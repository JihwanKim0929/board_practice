package com.example.rest_practice.Config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //csrf disable
        http
                .csrf((auth)->auth.disable());

        //Form 로그인 disable
        http
                .formLogin((auth)->auth.disable());

        //http basic disable
        http
                .httpBasic((auth)->auth.disable());

        http
                .authorizeHttpRequests((auth)->auth
                        .requestMatchers("/login","/","/join","/h2-console/**").permitAll()
                        .anyRequest().authenticated());

        http
                .sessionManagement((session)->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        //h2console 보기위한 설정(위의 requestMatchers의 "/h2-console/**"도)
        http
                .headers((headers)->headers.frameOptions((frameOptions)->frameOptions.sameOrigin()));
        return http.build();
    }
}
