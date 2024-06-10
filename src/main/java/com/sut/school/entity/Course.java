package com.sut.school.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicUpdate//表示在执行更新操作时，生成的 SQL 语句只包含实际被修改的字段，而不是包含所有字段。
@DynamicInsert//表示在执行插入操作时，生成的 SQL 语句只包含实际被赋值的字段，而不是包含所有字段。
@Table//name：如果没有指定，则默认值为实体类的名字。
@Entity//指定一个类是一个 JPA 实体。
@Data
public class Course {
    @Id//用于指定实体类中的主键字段。
    @GeneratedValue(strategy = GenerationType.IDENTITY)//定义主键字段的生成策略，这种策略通常依赖于数据库的自动递增列
    private Long id;

    @Column
    private String name;

    @Column
    private short credit;

    @Column
    private int teacher_id;

    @CreationTimestamp//Hibernate 提供的注解,用于自动将实体创建时的时间戳记录到数据库中。
    @Column//JPA 提供的注解,用于指定实体类的字段与数据库表中的列之间的映射关系,可以配置列的各种属性。(nullable = false, updatable = false)不能为空，在更新实体时不能被修改。
    private LocalDateTime addTime;// 是 Java 8 引入的新日期时间 API 的一部分，表示日期和时间

    @UpdateTimestamp
    @Column
    private LocalDateTime modTime;

}
