package com.dljsxy.school.web;

import com.dljsxy.school.entity.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.model.CourseModel;
import com.dljsxy.school.service.CourseService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;


@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){this.courseService = courseService;}

    @RequestMapping("/hello2")
    public String hello(Model mv) {
        CourseModel courseModel = new CourseModel();
//        user.setName("nt");
        Course course = courseService.getCourseInfoByName("run");
        BeanUtils.copyProperties(course, courseModel);

        mv.addAttribute("user", courseModel);
        return "Hello";
    }


}
