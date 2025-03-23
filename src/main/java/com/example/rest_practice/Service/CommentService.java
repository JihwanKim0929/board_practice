package com.example.rest_practice.Service;

import com.example.rest_practice.Dto.Request.Comment.CommentWriteDto;
import com.example.rest_practice.Dto.Response.Comment.ResCommentDto;
import com.example.rest_practice.Entity.Comment;
import com.example.rest_practice.Entity.Post;
import com.example.rest_practice.Repository.CommentRepository;
import com.example.rest_practice.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    public ResCommentDto write(Long postId, CommentWriteDto commentDto){
        Post post = postRepository.findById(postId).orElse(null);
        Comment comment = CommentWriteDto.ofEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return ResCommentDto.fromEntity(savedComment);
    }
}
