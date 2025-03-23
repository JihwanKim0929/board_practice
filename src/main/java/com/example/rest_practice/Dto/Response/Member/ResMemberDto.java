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

    private Long id;
    private String username;
    private String role;

    @Builder
    public ResMemberDto(Long id, String username, String role){
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public static ResMemberDto fromEntity(Member member){
        return ResMemberDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .role(member.getRole())
                .build();
    }
}
