package com.example.rest_practice.Dto.Request.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentUpdateDto {

    private String content;

    @Builder
    public CommentUpdateDto(String content){
        this.content = content;
    }
}
