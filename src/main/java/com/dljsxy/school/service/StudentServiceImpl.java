package com.dljsxy.school.service;

import com.dljsxy.school.constant.CommonConst;
import com.dljsxy.school.entity.Student;
import com.dljsxy.school.repository.StudentRepository;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public Student getStudentInfoByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Long addStudent(AddStudentReq req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getName() + CommonConst.SCHOOL_EMAIL_SUFFIX);
        student.setBirthday(LocalDate.now());
        return studentRepository.save(student).getId();
    }

}
