package com.example.rest_practice.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
