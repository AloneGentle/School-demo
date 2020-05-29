package com.dljsxy.school.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentModel {
    private String name;
    private LocalDate birthday;
    private String email;
}
