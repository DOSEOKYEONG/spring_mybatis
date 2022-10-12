package com.llm.exam.spring_mybatis.member.service;

import com.llm.exam.spring_mybatis.member.dto.Member;
import com.llm.exam.spring_mybatis.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Member getMemberByUsername(String username) {
        Member member = memberRepository.getMemberByUsername(username);
        return member;
    }
}
