package com.sut.school.service;

import com.sut.school.entity.Student;
import com.sut.school.web.reqRes.AddStudentReq;

import java.util.List;

public interface StudentService {
    Student getStudentInfoByName(String name);

    Long addStudent(AddStudentReq student);

    void updateStudent(long id, AddStudentReq updateStudentReq );

    List<Student> listStudent();

    void deleteStudent(long id);
}
