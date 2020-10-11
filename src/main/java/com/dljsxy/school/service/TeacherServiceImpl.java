package com.dljsxy.school.service;

import com.dljsxy.school.constant.CommonConst;
import com.dljsxy.school.entity.Teacher;
import com.dljsxy.school.repository.TeacherRepository;
import com.dljsxy.school.web.reqRes.AddTeacherReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;


    @Override
    public Teacher getTeacherInfoByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public Long addTeacher(AddTeacherReq req){
        Teacher teacher = new Teacher();
        teacher.setName(req.getName());
        return teacherRepository.save(teacher).getId();
    }
}
