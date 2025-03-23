package com.example.rest_practice.Dto.Request.Post;

import com.example.rest_practice.Entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostWriteDto {
    String title;
    String content;

    @Builder
    public PostWriteDto(String title, String content){
        this.title=title;
        this.content=content;
    }

    public static Post ofEntity(PostWriteDto dto){
        return Post.builder()
                .title(dto.title)
                .content(dto.content)
                .build();
    }
}
