package com.example.rest_practice.Controller;

import com.example.rest_practice.Dto.Request.Member.MemberJoinDto;
import com.example.rest_practice.Dto.Response.Member.ResMemberDto;
import com.example.rest_practice.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<ResMemberDto> join(@RequestBody MemberJoinDto memberJoinDto){
        ResMemberDto joinedMember = memberService.join(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(joinedMember);
    }
}
