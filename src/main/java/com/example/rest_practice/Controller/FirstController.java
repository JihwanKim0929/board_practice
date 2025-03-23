package com.example.rest_practice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    String getHello(){
        return "hello";
    }
}
