package com.example.rest_practice.Dto.Request.Member;

import com.example.rest_practice.Entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberJoinDto {

    private String username;
    private String password;

    @Builder
    public MemberJoinDto(String username, String password){
        this.username=username;
        this.password=password;
    }

    public static Member ofEntity(MemberJoinDto dto){
        return Member.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role("ROLE_ADMIN")
                .build();
    }
}
