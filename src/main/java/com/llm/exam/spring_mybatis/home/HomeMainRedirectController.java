package com.llm.exam.spring_mybatis.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeMainRedirectController {
    @RequestMapping("/")
    public String redirectToMain() {
        return "redirect:/home/main";
    }
}