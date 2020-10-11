package com.dljsxy.school.service;

import com.dljsxy.school.entity.Teacher;
import com.dljsxy.school.web.reqRes.AddTeacherReq;


public interface TeacherService {
    Teacher getTeacherInfoByName(String name);

    Long addTeacher(AddTeacherReq teacher);
}
