package com.sut.school.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Table
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @CreationTimestamp
    @Column
    private LocalDateTime addTime;

    @UpdateTimestamp
    @Column
    private LocalDateTime modTime;

}
