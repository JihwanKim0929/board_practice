package com.example.rest_practice.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="POST_ID")
    Post post;

    @Builder
    public Comment(Long id, String content, Post post){
        this.id = id;
        this.content = content;
        this.post = post;
    }

    public void setPost(Post post){
        this.post = post;
        post.getComments().add(this);
    }
}
