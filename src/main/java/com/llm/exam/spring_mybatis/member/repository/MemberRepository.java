package com.llm.exam.spring_mybatis.member.repository;

import com.llm.exam.spring_mybatis.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

    @Select("""
            <script>
            SELECT *
            FROM member
            WHERE username = #{username}
            </script>
            """)
    Member getMemberByUsername(@Param("username") String username);
}
