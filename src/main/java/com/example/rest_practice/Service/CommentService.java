package com.example.rest_practice.Service;

import com.example.rest_practice.Dto.Request.Comment.CommentUpdateDto;
import com.example.rest_practice.Dto.Request.Comment.CommentWriteDto;
import com.example.rest_practice.Dto.Response.Comment.ResCommentDto;
import com.example.rest_practice.Entity.Comment;
import com.example.rest_practice.Entity.Member;
import com.example.rest_practice.Entity.Post;
import com.example.rest_practice.Repository.CommentRepository;
import com.example.rest_practice.Repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    public ResCommentDto write(Long postId, CommentWriteDto commentDto, String username){
        Post post = postRepository.findById(postId).orElse(null);
        Member member = memberRepository.findByUsername(username);
        Comment comment = CommentWriteDto.ofEntity(commentDto);
        comment.setPost(post);
        comment.setMember(member);
        Comment savedComment = commentRepository.save(comment);
        return ResCommentDto.fromEntity(savedComment);
    }

    public ResCommentDto update(Long commentId, CommentUpdateDto commentUpdateDto) {
        Comment target = commentRepository.findById(commentId).orElse(null);
        target.update(commentUpdateDto.getContent());
        return ResCommentDto.fromEntity(target);
    }

    public void delete(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
