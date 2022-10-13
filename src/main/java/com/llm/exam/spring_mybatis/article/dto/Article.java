package com.llm.exam.spring_mybatis.article.dto;

import lombok.Data;

@Data
public class Article {
    private long id;
    private String subject;
    private String content;
    private long memberId;

    private String extra_member_username;
    private String extra_member_name;
}
