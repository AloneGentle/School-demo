package com.sut.school.service.impl;

import com.sut.school.entity.Teacher;
import com.sut.school.repository.TeacherRepository;
import com.sut.school.service.TeacherService;
import com.sut.school.web.reqRes.AddTeacherReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> listTeacher()  {
        return teacherRepository.findAll();
    }

    @Override
    public void updateTeacher(long id, AddTeacherReq updateTeacherReq) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.setName(updateTeacherReq.getName());
        teacher.setAge(updateTeacherReq.getAge());
        teacherRepository.save(teacher);
    }

    @Override
    public long addTeacher(AddTeacherReq addTeacherReq) {
        Teacher teacher = new Teacher();
        teacher.setName(addTeacherReq.getName());
        teacher.setAge(addTeacherReq.getAge());
        return teacherRepository.save(teacher).getId();
    }

    @Override
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> findTeachersByName(String name) {
        return teacherRepository.findByNameContaining(name);
    }
}
