package com.example.rest_practice.Dto.Response.Post;

import com.example.rest_practice.Dto.Response.Comment.ResCommentDto;
import com.example.rest_practice.Dto.Response.Member.ResMemberDto;
import com.example.rest_practice.Entity.Member;
import com.example.rest_practice.Entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ResPostDetailDto {
    private Long id;
    private String title;
    private String content;
    private ResMemberDto member;
    private List<ResCommentDto> comments;

    @Builder
    public ResPostDetailDto(Long id, String title, String content, ResMemberDto member, List<ResCommentDto> comments){
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
        this.comments = comments;
    }

    public static ResPostDetailDto fromEntity(Post post){
        return ResPostDetailDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .member(ResMemberDto.fromEntity(post.getMember()))
                .comments(post.getComments().stream()
                        .map(ResCommentDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
