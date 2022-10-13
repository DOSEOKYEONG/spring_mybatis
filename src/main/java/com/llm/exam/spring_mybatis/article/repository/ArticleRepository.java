package com.llm.exam.spring_mybatis.article.repository;

import com.llm.exam.spring_mybatis.article.dto.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {
    @Select("""
            <script>
            SELECT *
            FROM article
            </script>
            """)
    List<Article> getArticles();

    @Select("""
            <script>
            SELECT A.*, 
            M.username AS extra_member_username,
            M.name AS extra_member_name
            FROM article as A
            INNER JOIN member as M
            ON A.memberId = M.id;
            </script>
            """)
    List<Article> getForPrintArticles();

    @Insert("""
            <script>
            INSERT INTO article
            SET createDate = NOW(),
            modifyDate = NOW(),
            subject = #{subject},
            content = #{content}
            </script>
            """)
    void write(@Param("subject") String subject, @Param("content") String content); // 변경

    @Select("""
            SELECT LAST_INSERT_ID()
            """)
    long getLastInsertId();

    @Select("""
            <script>
            SELECT *
            FROM article
            WHERE id = #{articleId}
            </script>
            """)
    Article getArticleById(@Param("articleId") long articleId);

    @Select("""
			<script>
			SELECT A.*
			FROM article AS A
			WHERE 1
			<if test="kw != ''">
			AND A.subject LIKE CONCAT('%', #{kw}, '%')
			</if>
			</script>
			""")
    List<Article> search(@Param("kwType") String kwType, @Param("kw") String kw);
}
