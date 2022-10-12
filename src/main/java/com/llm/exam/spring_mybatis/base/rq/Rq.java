package com.llm.exam.spring_mybatis.base.rq;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Rq {

    @Setter
    @Getter
    private String name;
    @Getter
    private int count;

    public void increaseCount() {
        count++;
    }

}
