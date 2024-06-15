create database school_demo default character set utf8mb4 collate utf8mb4_unicode_ci;

use school_demo;
create table student
(
    id         bigint       not null primary key auto_increment,
    birthday   date         not null default '1970-01-01' comment '生日',
    start_year smallint     not null default '0' comment '入学年份',
    name       varchar(64)  not null default '' comment 'name',
    email      varchar(128) not null default '' comment 'email',
    add_time   datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time   datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间'
) ENGINE = InnoDB comment '学生信息表';

create table course
(
    id         bigint      not null primary key auto_increment,
    name       varchar(32) not null default '' comment '名称',
    credit     smallint    not null default 0 comment '学分 * 100',
    teacher_id int         not null default 0 comment '教师id',
    add_time   datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time   datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间'

) ENGINE = InnoDB comment '课程信息表';

create table teacher
(
    id       bigint       not null primary key auto_increment,
    name     varchar(64)  not null default '' comment 'name',
    age      int          not null default '' comment '年龄',
    email    varchar(128) not null default '' comment 'email',
    add_time datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间'
) ENGINE = InnoDB comment '教师信息表';
create table user
(
    id           bigint       not null primary key auto_increment,
    username     varchar(64)  not null default '' comment 'username',
    password     varchar(64)  not null default '' comment 'password',
    add_time     datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time     datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    name         varchar(64)  not null default '' comment 'Super Admin',
    avatar       varchar(256) not null default '' comment 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    introduction varchar(256) not null default '' comment 'I am a super administrator',
    roles        varchar(64)  not null default '' comment 'admin'
) ENGINE = InnoDB comment '用户信息表';
CREATE TABLE score
(
   id          BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
   student_id  BIGINT       NOT NULL COMMENT '学生ID',
   course_id   BIGINT       NOT NULL COMMENT '课程ID',
   score       INT          NOT NULL DEFAULT 0 COMMENT '成绩',
   add_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   mod_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id),
   CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(id)
) ENGINE = InnoDB COMMENT '成绩信息表';


INSERT INTO school_demo.student (id, birthday, start_year, name, email, add_time, mod_time)
VALUES (1, '1970-01-01', 2019, 'tom', 'tom.2019', '2020-10-13 20:17:45', '2020-10-13 20:19:20');
INSERT INTO school_demo.student (id, birthday, start_year, name, email, add_time, mod_time)
VALUES (2, '1970-01-01', 2019, 'jerry', 'jerry.1', '2020-10-13 20:17:45', '2020-10-13 20:19:20');


INSERT INTO school_demo.teacher (name, email, add_time, mod_time)
VALUES ('老张', 'zhang@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:16');
INSERT INTO school_demo.teacher (name, email, add_time, mod_time)
VALUES ('William Jafferson', 'William@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:16');
INSERT INTO school_demo.teacher (name, email, add_time, mod_time)
VALUES ('George Bush', 'Bush@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:30');
