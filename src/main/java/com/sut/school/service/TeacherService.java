package com.sut.school.service;

import com.sut.school.entity.Teacher;
import com.sut.school.web.reqRes.AddTeacherReq;

import java.util.List;


public interface TeacherService {

    long addTeacher(AddTeacherReq teacher);

    void deleteTeacher(long id);

    void updateTeacher(long id, AddTeacherReq updateTeacherReq );

    List<Teacher> listTeacher();

    List<Teacher> findTeachersByName(String name);
}
