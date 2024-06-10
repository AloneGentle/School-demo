package com.sut.school.service;

import com.sut.school.entity.Course;
import com.sut.school.repository.CourseRepository;
import com.sut.school.web.reqRes.AddCourseReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseRepository courseRepository;

    @Override
    public long addCourse(AddCourseReq req) {
        Course course = new Course();
        course.setName(req.getName());
        course.setCredit(req.getCredit());
        course.setTeacher_id(req.getTeacherId());
        return courseRepository.save(course).getId();
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> listCourse() {
        return courseRepository.findAll();
    }

}
