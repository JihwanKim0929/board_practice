package com.example.rest_practice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    @Builder
    public Member(Long id, String username, String password, String role){
        this.id=id;
        this.username=username;
        this.password=password;
        this.role=role;
    }
}
