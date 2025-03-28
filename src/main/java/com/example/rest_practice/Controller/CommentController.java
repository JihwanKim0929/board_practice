package com.example.rest_practice.Controller;

import com.example.rest_practice.Dto.Request.Comment.CommentUpdateDto;
import com.example.rest_practice.Dto.Request.Comment.CommentWriteDto;
import com.example.rest_practice.Dto.Response.Comment.ResCommentDto;
import com.example.rest_practice.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post/{id}/comment/write")
    public ResponseEntity<ResCommentDto> write(@PathVariable("id") Long postId, @RequestBody CommentWriteDto commentDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ResCommentDto savedCommentDto = commentService.write(postId,commentDto,username);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentDto);
    }

    @PatchMapping("/comment/{id}/update")
    public ResponseEntity<ResCommentDto> update(@PathVariable("id") Long commentId, @RequestBody CommentUpdateDto commentUpdateDto){
        ResCommentDto updatedCommentDto = commentService.update(commentId,commentUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCommentDto);
    }

    @DeleteMapping("/comment/{id}/delete")
    public ResponseEntity<Long> delete(@PathVariable("id")Long commentId){
        commentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
