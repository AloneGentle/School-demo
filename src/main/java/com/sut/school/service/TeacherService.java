package com.sut.school.service;

import com.sut.school.entity.Teacher;
import com.sut.school.web.reqRes.AddTeacherReq;

import java.util.List;


public interface TeacherService {
    Teacher getTeacherInfoByName(String name);

    long addTeacher(AddTeacherReq teacher);

    void deleteTeacher(long id);

    List<Teacher> listTeacher();
}
