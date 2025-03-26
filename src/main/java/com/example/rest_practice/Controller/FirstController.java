package com.example.rest_practice.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

@RestController
public class FirstController {
    @GetMapping("/")
    String getHello(){
        return "hello";
    }

    @GetMapping("/who")
    public ResponseEntity<String> who(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //현재 로그인 한 사용자 유저네임
        String username = authentication.getName();

        //현재 로그인 한 사용자 role
        Collection<?extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return ResponseEntity.status(HttpStatus.OK).body("username : "+username+"\nrole : "+role);
    }

}
