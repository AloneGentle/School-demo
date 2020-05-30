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

