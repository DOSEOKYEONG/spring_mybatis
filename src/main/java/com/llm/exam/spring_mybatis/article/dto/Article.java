package com.llm.exam.spring_mybatis.article.dto;

import lombok.Data;

@Data
public class Article {
    private long id;
    private String subject;
    private String content;
}
