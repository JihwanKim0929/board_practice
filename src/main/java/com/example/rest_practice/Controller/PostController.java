package com.example.rest_practice.Controller;

import com.example.rest_practice.Dto.Request.Post.PostWriteDto;
import com.example.rest_practice.Dto.Response.Post.ResPostDetailDto;
import com.example.rest_practice.Dto.Response.Post.ResPostListDto;
import com.example.rest_practice.Dto.Response.Post.ResPostWriteDto;
import com.example.rest_practice.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public ResponseEntity<List<ResPostListDto>> postList() {
        List<ResPostListDto> boardList = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PostMapping("/write")
    public ResponseEntity<ResPostWriteDto> write(@RequestBody PostWriteDto postDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ResPostWriteDto savedPostDto = postService.write(postDto,username);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPostDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResPostDetailDto> detail(@PathVariable("id") Long postId){
        ResPostDetailDto postDto = postService.detail(postId);
        return ResponseEntity.status(HttpStatus.OK).body(postDto);
    }
}
