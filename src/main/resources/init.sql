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
    email    varchar(128) not null default '' comment 'email',
    add_time datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间'
) ENGINE = InnoDB comment '教师信息表';
create table user
(
    id       bigint       not null primary key auto_increment,
    username     varchar(64)  not null default '' comment 'username',
    password     varchar(64)  not null default '' comment 'password',
    add_time datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    mod_time datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间'
) ENGINE = InnoDB comment '用户信息表';

INSERT INTO school_demo.student (id, birthday, start_year, name, email, add_time, mod_time) VALUES (1, '1970-01-01', 2019, 'tom', 'tom.2019', '2020-10-13 20:17:45', '2020-10-13 20:19:20');
INSERT INTO school_demo.student (id, birthday, start_year, name, email, add_time, mod_time) VALUES (2, '1970-01-01', 2019, 'jerry', 'jerry.1', '2020-10-13 20:17:45', '2020-10-13 20:19:20');


INSERT INTO school_demo.teacher (name, email, add_time, mod_time) VALUES ('老张', 'zhang@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:16');
INSERT INTO school_demo.teacher (name, email, add_time, mod_time) VALUES ('William Jafferson', 'William@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:16');
INSERT INTO school_demo.teacher (name, email, add_time, mod_time) VALUES ('George Bush', 'Bush@ly.edu', '2020-12-05 17:35:16', '2020-12-05 17:35:30');
