 create database school_demo default character set utf8mb4 collate utf8mb4_unicode_ci;

create table school_demo.student (
    id bigint not null primary key auto_increment,
    birthday date not null default "1970-01-01" comment '生日',
    email varchar(128) not null default '' comment 'email',
    add_time datetime not null default CURRENT_TIMESTAMP,
    mod_time datetime default CURRENT_TIMESTAMP not null  on update CURRENT_TIMESTAMP comment '修改时间'
) ENGINE=InnoDB comment '学生信息表';
