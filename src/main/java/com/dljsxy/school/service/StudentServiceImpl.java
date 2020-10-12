package com.dljsxy.school.service;

import com.dljsxy.school.constant.CommonConst;
import com.dljsxy.school.entity.Student;
import com.dljsxy.school.repository.StudentRepository;
import com.dljsxy.school.utils.CacheUtil;
import com.dljsxy.school.utils.JacksonUtil;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Resource
    private StudentRepository studentRepository;

    @Override
    public Student getStudentInfoByName(String name) {
        String student = redisTemplate.opsForValue().get(CacheUtil.studentCacheKey(name));

        if (student != null) {
            JacksonUtil.DEFAULT_MAPPER.readValues(student, new TypeReference<Student.class>(){

            });
        }
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
