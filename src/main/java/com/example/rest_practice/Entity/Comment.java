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
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="POST_ID")
    private Post post;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

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

    public void setMember(Member member){
        this.member = member;
        member.getComments().add(this);
    }
}
