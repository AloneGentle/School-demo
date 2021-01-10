package com.dljsxy.school.web;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.service.CourseService;
import com.dljsxy.school.web.reqRes.AddCourseReq;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;


@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){this.courseService = courseService;}

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
