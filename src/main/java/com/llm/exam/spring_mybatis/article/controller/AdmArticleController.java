package com.llm.exam.spring_mybatis.article.controller;

import com.llm.exam.spring_mybatis.article.dto.Article;
import com.llm.exam.spring_mybatis.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adm/article")
@RequiredArgsConstructor
public class AdmArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Article> articles = articleService.getForPrintArticles();

        model.addAttribute("articles", articles);

        return "adm/article/list";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable Long id) {
        return "adm/article/detail";
    }
}
