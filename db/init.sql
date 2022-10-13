# DB 생성
DROP DATABASE IF EXISTS spring_mybatis;
CREATE DATABASE spring_mybatis;
USE spring_mybatis;

# 게시물 테이블 생성
CREATE TABLE article (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         createDate DATETIME NOT NULL,
                         modifyDate DATETIME NOT NULL,
                         `subject` CHAR(100) NOT NULL,
                         content LONGTEXT NOT NULL
);

# 게시물 데이터
INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목1',
content = '내용1';

INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목2',
content = '내용2';

# 회원 테이블 생성
CREATE TABLE `member` (
                          id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                          PRIMARY KEY(id),
                          createDate DATETIME NOT NULL,
                          modifyDate DATETIME NOT NULL,
                          username CHAR(100) NOT NULL UNIQUE,
                          `password` CHAR(100) NOT NULL,
                          `name` CHAR(100) NOT NULL,
                          email CHAR(100) NOT NULL
);

# 회원 데이터
INSERT INTO `member`
SET createDate = NOW(),
modifyDate = NOW(),
username = 'user1',
`password` = '{noop}1234',
`name` = '유저1',
email = 'user1@test.com';

INSERT INTO `member`
SET createDate = NOW(),
modifyDate = NOW(),
username = 'user2',
`password` = '{noop}1234',
`name` = '유저2',
email = 'user2@test.com';

SELECT *
FROM `member`;

# 게시물에 작성자 정보 추가

alter table article
add column member_id BIGINT UNSIGNED NOT NULL AFTER modifyDate;

update article
set member_id = 2;

alter table article
rename column member_id TO memberId;

alter table member
add column roles CHAR(50) NOT NULL AFTER modifyDate;

# admin 추가
INSERT INTO `member`
SET createDate = NOW(),
modifyDate = NOW(),
roles = 'ADMIN, MEMBER',
username = 'admin',
`password` = '{noop}1234',
`name` = 'admin',
email = 'admin@test.com';