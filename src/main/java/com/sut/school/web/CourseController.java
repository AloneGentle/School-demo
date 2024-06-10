package com.sut.school.web;

import com.sut.school.entity.Course;
import com.sut.school.service.CourseService;
import com.sut.school.web.reqRes.AddCourseReq;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add-course")
    public long addCourse(@RequestBody AddCourseReq req) {
        return courseService.addCourse(req);
    }

    @DeleteMapping("delete-course/{id}")
    public void deleteCourse(@PathVariable long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/list")
    public BaseApiRes<List<Course>> listCourse(Long req) {
        BaseApiRes<List<Course>> ret = new BaseApiRes<>();
        ret.setData(courseService.listCourse());
        return ret;
    }
}
