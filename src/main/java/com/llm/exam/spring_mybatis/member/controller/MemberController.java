package com.llm.exam.spring_mybatis.member.controller;

import com.llm.exam.spring_mybatis.base.rq.Rq;
import com.llm.exam.spring_mybatis.member.dto.Member;
import com.llm.exam.spring_mybatis.member.service.MemberService;
import com.llm.exam.spring_mybatis.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @GetMapping("/me")
    @ResponseBody
    public Member getMe() {
        return rq.getLoginedMember();
    }


    @GetMapping("/login")
    public String showLogin() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        Member member = memberService.getMemberByUsername(username);

        if (member == null) {
            return rq.historyBackTemplate("일치하는 회원이 없습니다.");
        }

        if (member.matchPassword(password) == false) {
            return rq.historyBackTemplate("패스워드가 일치하지 않습니다.");
        }

        rq.setLoginDone(member);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        rq.setLogoutDone();

        return "redirect:/?msg=" + Util.url.encode("로그아웃 성공");
    }

}
