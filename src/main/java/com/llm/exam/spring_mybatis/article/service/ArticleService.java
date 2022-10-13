package com.llm.exam.spring_mybatis.article.service;

import com.llm.exam.spring_mybatis.article.dto.Article;
import com.llm.exam.spring_mybatis.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public long write(String subject, String content) {
        articleRepository.write(subject, content);
        long id = articleRepository.getLastInsertId();
        return id;
    }

    public Article getArticleById(long id) {
        return articleRepository.getArticleById(id);
    }

    public List<Article> search(String kwType, String kw) {
        List<Article> articleList = articleRepository.search(kwType, kw);

        return articleList;
    }

    public List<Article> getForPrintArticles() {
        return articleRepository.getForPrintArticles();
    }
}
