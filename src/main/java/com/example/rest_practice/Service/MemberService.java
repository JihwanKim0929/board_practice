package com.example.rest_practice.Service;

import com.example.rest_practice.Dto.Request.Member.MemberJoinDto;
import com.example.rest_practice.Dto.Response.Member.ResMemberDto;
import com.example.rest_practice.Entity.Member;
import com.example.rest_practice.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResMemberDto join(MemberJoinDto memberJoinDto){

        boolean isExist = memberRepository.existsByUsername(memberJoinDto.getUsername());
        if(isExist)
            return null;

        String encodedPassword = bCryptPasswordEncoder.encode(memberJoinDto.getPassword());
        memberJoinDto.setPassword(encodedPassword);
        Member member = MemberJoinDto.ofEntity(memberJoinDto);
        Member joinedMember = memberRepository.save(member);
        return ResMemberDto.fromEntity(joinedMember);
    }
}
