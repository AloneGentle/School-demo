package com.sut.school.web;

import com.sut.school.entity.Course;
import com.sut.school.service.CourseService;
import com.sut.school.web.reqRes.AddCourseReq;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public BaseApiRes<List<Course>> listCourse() {
        BaseApiRes<List<Course>> ret = new BaseApiRes<>();
        ret.setData(courseService.listCourse());
        return ret;
    }

    @PutMapping("/update-course/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody AddCourseReq updateTeacherReq ) {
        courseService.updateCourse(id, updateTeacherReq);
    }

        @PostMapping("/add-course")
    public long addCourse(@RequestBody AddCourseReq addCourseReq ) {
        return courseService.addCourse(addCourseReq);
    }

    @DeleteMapping("/delete-course/{id}")
    public void deleteCourse(@PathVariable long id) {
        courseService.deleteCourse(id);
    }

}
