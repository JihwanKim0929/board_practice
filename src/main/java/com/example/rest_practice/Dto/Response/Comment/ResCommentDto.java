package com.example.rest_practice.Dto.Response.Comment;

import com.example.rest_practice.Dto.Response.Member.ResMemberDto;
import com.example.rest_practice.Entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResCommentDto {
    private Long id;
    private String content;
    private ResMemberDto member;

    @Builder
    public ResCommentDto(Long id, String content, ResMemberDto member){
        this.id = id;
        this.content = content;
        this.member = member;
    }

    public static ResCommentDto fromEntity(Comment comment){
        return ResCommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .member(ResMemberDto.fromEntity(comment.getMember()))
                .build();
    }
}
