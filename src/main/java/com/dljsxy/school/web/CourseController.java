package com.dljsxy.school.web;

import com.dljsxy.school.entity.Course;
import com.dljsxy.school.web.reqRes.AddCourseReq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.model.CourseModel;
import com.dljsxy.school.service.CourseService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.BeanUtils;
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
        return "hello";
    }

    @RequestMapping("/add-course")
    @ResponseBody
    public long addCourse(AddCourseReq req){ return courseService.addCourse(req);}


    @RequestMapping("/add")
    @ResponseBody
    public long addCourse(Long req){
        if (req.equals(1L)){

            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        }else if (req.equals(2L)){
            throw new GenericJDBCException("xxx",new SQLException());
        }else{
            throw new RuntimeException();
        }
    }
}
