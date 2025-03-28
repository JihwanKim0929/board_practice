package com.example.rest_practice.Dto.Response.Post;

import com.example.rest_practice.Dto.Response.Member.ResMemberDto;
import com.example.rest_practice.Entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPostListDto {
    private Long id;
    private String title;
    private String content;
    private ResMemberDto member;

    @Builder
    public ResPostListDto(Long id, String title, String content, ResMemberDto member){
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public static ResPostListDto fromEntity(Post post){
        return ResPostListDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .member(ResMemberDto.fromEntity(post.getMember()))
                .build();
    }
}
