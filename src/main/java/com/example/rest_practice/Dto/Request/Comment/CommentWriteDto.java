package com.example.rest_practice.Dto.Request.Comment;

import com.example.rest_practice.Entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentWriteDto {
    String content;

    @Builder
    public CommentWriteDto(String content){
        this.content = content;
    }

    public static Comment ofEntity(CommentWriteDto dto) {
        return Comment.builder()
                .content(dto.getContent())
                .build();
    }
}
