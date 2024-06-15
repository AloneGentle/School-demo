package com.sut.school.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sut.school.constant.CommonConst;
import com.sut.school.entity.Student;
import com.sut.school.repository.StudentRepository;
import com.sut.school.service.StudentService;
import com.sut.school.utils.CacheUtil;
import com.sut.school.web.reqRes.AddStudentReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StringRedisTemplate redis;

    @Autowired
    ObjectMapper objectMapper;

    @Resource
    private StudentRepository studentRepository;

    @Override
    public Student getStudentInfoByName(String name) {
        String cacheKey = CacheUtil.studentCacheKey(name);
        String studentStr = redis.opsForValue().get(cacheKey);

        log.info("get in cache,student:{}", studentStr);

        Student student = null;
        if (studentStr != null) {
            try {
                student = objectMapper.readValue(studentStr, new TypeReference<>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        if (student == null) {
            student = studentRepository.findByName(name);
            try {
                redis.opsForValue().set(cacheKey, objectMapper.writeValueAsString(student));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public Long addStudent(AddStudentReq addStudentReq) {
        Student student = new Student();
        student.setName(addStudentReq.getName());
        student.setEmail(addStudentReq.getName() + CommonConst.SCHOOL_EMAIL_SUFFIX);
        student.setBirthday(addStudentReq.getBirthday());
        student.setStartYear(addStudentReq.getStartYear());
        return studentRepository.save(student).getId();
    }

    @Override
    public void updateStudent(long id, AddStudentReq updateStudentReq) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        student.setName(updateStudentReq.getName());
        student.setEmail(updateStudentReq.getEmail());
        student.setBirthday(updateStudentReq.getBirthday());
        student.setStartYear(updateStudentReq.getStartYear());
        studentRepository.save(student);
    }

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

}
