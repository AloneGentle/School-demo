package com.dljsxy.school.service;

import com.dljsxy.school.entity.Student;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @Test
    void addStudent() {
        String name = "run";
        Student studentInDbBefore = studentService.getStudentInfoByName(name);
        if (studentInDbBefore != null) {
            return;
        }
        AddStudentReq req = new AddStudentReq();
        req.setName(name);
        Long id = studentService.addStudent(req);
        Student studentInDb = studentService.getStudentInfoByName(name);
        assertNotNull(id);
        assertNotNull(studentInDb);
    }
}