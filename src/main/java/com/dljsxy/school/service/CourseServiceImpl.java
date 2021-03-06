package com.dljsxy.school.service;

import com.dljsxy.school.constant.CommonConst;
import com.dljsxy.school.entity.Course;
import com.dljsxy.school.repository.CourseRepository;
import com.dljsxy.school.web.reqRes.AddCourseReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private  CourseRepository courseRepository;

    @Override
    public Course getCourseInfoByName(String name) {

        return courseRepository.findByName(name);
    }

    @Override
    public Long addCourse(AddCourseReq req) {
        Course course = new Course();
        course.setName(req.getName());
        course.setCredit(course.getCredit());
        return courseRepository.save(course).getId();
    }

}
