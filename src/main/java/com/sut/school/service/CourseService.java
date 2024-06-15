package com.sut.school.service;

import com.sut.school.entity.Course;
import com.sut.school.web.reqRes.AddCourseReq;

import java.util.List;

public interface CourseService {

    long addCourse(AddCourseReq course);

    void updateCourse(long id,AddCourseReq updateCourseReq);


    void deleteCourse(long id);

    List<Course> listCourse();

}
