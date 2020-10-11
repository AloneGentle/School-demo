package com.dljsxy.school.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@Getter
@Setter
@ToString

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private short credit;

    @Column
    private int teacher_id;

    @CreationTimestamp
    @Column
    private LocalDateTime addTime;

    @UpdateTimestamp
    @Column
    private LocalDateTime modTime;
}
