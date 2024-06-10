package com.sut.school.service;

import com.sut.school.constant.CommonConst;
import com.sut.school.entity.Teacher;
import com.sut.school.repository.TeacherRepository;
import com.sut.school.web.reqRes.AddTeacherReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacherInfoByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public long addTeacher(AddTeacherReq addTeacherReq){
        Teacher teacher = new Teacher();
        teacher.setName(addTeacherReq.getName());
        teacher.setEmail(addTeacherReq.getEmail()+ CommonConst.SCHOOL_EMAIL_SUFFIX);
        return teacherRepository.save(teacher).getId();
    }

    @Override
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherRepository.findAll();
    }
}
