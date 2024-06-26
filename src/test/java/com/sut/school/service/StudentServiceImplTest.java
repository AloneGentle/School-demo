package com.sut.school.service;

import com.sut.school.entity.Student;
import com.sut.school.web.reqRes.AddStudentReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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
