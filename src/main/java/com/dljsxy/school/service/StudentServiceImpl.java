package com.dljsxy.school.service;

import com.dljsxy.school.constant.CommonConst;
import com.dljsxy.school.entity.Student;
import com.dljsxy.school.repository.StudentRepository;
import com.dljsxy.school.utils.CacheUtil;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

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
    public Long addStudent(AddStudentReq req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getName() + CommonConst.SCHOOL_EMAIL_SUFFIX);
        student.setBirthday(LocalDate.now());
        return studentRepository.save(student).getId();
    }

}
