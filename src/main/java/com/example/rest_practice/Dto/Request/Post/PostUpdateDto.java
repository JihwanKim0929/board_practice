package com.example.rest_practice.Dto.Request.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUpdateDto {

    private String title;
    private String content;

    @Builder
    public PostUpdateDto(String title, String content){
        this.title = title;
        this.content = title;
    }
}
