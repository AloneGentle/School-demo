package com.sut.school.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Table
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private LocalDate birthday;

    @Column
    private short startYear;


    @CreationTimestamp
    @Column
    private LocalDateTime addTime;

    @UpdateTimestamp
    @Column
    private LocalDateTime modTime;

}
