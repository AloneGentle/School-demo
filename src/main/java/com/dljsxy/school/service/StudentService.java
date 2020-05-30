package com.dljsxy.school.service;

import com.dljsxy.school.entity.Student;
import com.dljsxy.school.web.reqRes.AddStudentReq;

public interface StudentService {
    Student getStudentInfoByName(String name);

    Long addStudent(AddStudentReq student);
}
