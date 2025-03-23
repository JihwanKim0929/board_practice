package com.example.rest_practice.Dto.Response.Member;

import com.example.rest_practice.Entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResMemberDto {

    private String username;

    @Builder
    public ResMemberDto(String username){
        this.username = username;
    }

    public static ResMemberDto fromEntity(Member member){
        return ResMemberDto.builder()
                .username(member.getUsername())
                .build();
    }
}
