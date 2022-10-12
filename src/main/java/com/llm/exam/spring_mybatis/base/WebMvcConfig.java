package com.llm.exam.spring_mybatis.base;

import com.llm.exam.spring_mybatis.interceptor.BeforeActionInterceptor;
import com.llm.exam.spring_mybatis.interceptor.NeedToLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final BeforeActionInterceptor beforeActionInterceptor;
    private final NeedToLoginInterceptor needToLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir;


        ir = registry.addInterceptor(beforeActionInterceptor);
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/favicon.ico");
        ir.excludePathPatterns("/resource/**");
        ir.excludePathPatterns("/gen/**");
        ir.excludePathPatterns("/error");

        ir = registry.addInterceptor(needToLoginInterceptor);
        ir.addPathPatterns("/article/write");
    }
}
