package com.dljsxy.school.service;

import com.dljsxy.school.entity.Course;
import com.dljsxy.school.web.reqRes.AddCourseReq;

public interface CourseService {
    Course getCourseInfoByName(String name);

    Long addCourse(AddCourseReq course);


}
