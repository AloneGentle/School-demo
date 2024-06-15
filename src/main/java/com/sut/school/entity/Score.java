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
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private Long score;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime addTime;

    @Column(nullable = false)
    @UpdateTimestamp
    public LocalDateTime modTime;


}
