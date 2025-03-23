package com.example.rest_practice.Service;

import com.example.rest_practice.Dto.Request.Post.PostWriteDto;
import com.example.rest_practice.Dto.Response.Post.ResPostDetailDto;
import com.example.rest_practice.Dto.Response.Post.ResPostWriteDto;
import com.example.rest_practice.Dto.Response.Post.ResPostListDto;
import com.example.rest_practice.Entity.Post;
import com.example.rest_practice.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public List<ResPostListDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(ResPostListDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ResPostWriteDto write(PostWriteDto postDto){
        Post post = PostWriteDto.ofEntity(postDto);
        Post savedPost = postRepository.save(post);
        return ResPostWriteDto.fromEntity(savedPost);
    }

    public ResPostDetailDto detail(Long id){
        Post post = postRepository.findById(id).orElse(null);
        return ResPostDetailDto.fromEntity(post);
    }
}
