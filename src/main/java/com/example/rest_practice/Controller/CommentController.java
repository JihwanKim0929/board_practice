package com.example.rest_practice.Controller;

import com.example.rest_practice.Dto.Request.Comment.CommentWriteDto;
import com.example.rest_practice.Dto.Response.Comment.ResCommentDto;
import com.example.rest_practice.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post/{id}/comment/write")
    public ResponseEntity<ResCommentDto> write(@PathVariable("id") Long postId, @RequestBody CommentWriteDto commentDto){
        ResCommentDto savedCommentDto = commentService.write(postId,commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentDto);
    }
    
}
