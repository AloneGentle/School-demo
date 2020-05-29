package com.dljsxy.school.service;

import com.dljsxy.school.entity.Student;
import com.dljsxy.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public Student getStudentInfoByName(String name) {
        return studentRepository.findByName(name);
    }

}
