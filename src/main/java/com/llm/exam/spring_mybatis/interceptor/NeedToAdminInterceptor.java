package com.llm.exam.spring_mybatis.interceptor;

import com.llm.exam.spring_mybatis.base.rq.Rq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
@RequiredArgsConstructor
public class NeedToAdminInterceptor implements HandlerInterceptor {
    private final Rq rq;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("NeedToLoginInterceptor::preHandle 실행됨");

        if (rq.isAdmin() == false) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().append("관리자만 이용바랍니다.");

            return false;

        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
