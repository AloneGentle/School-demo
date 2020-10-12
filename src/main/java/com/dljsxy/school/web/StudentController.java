package com.dljsxy.school.web;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.entity.Student;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.model.StudentModel;
import com.dljsxy.school.service.StudentService;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * @author ningtao
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/info")
    public String info(Model mv) {
        StudentModel studentModel = new StudentModel();
        Student student = studentService.getStudentInfoByName("run");
        BeanUtils.copyProperties(student, studentModel);
        mv.addAttribute("studentModel", studentModel);
        return "hello";
    }

    @RequestMapping("/add-student")
    @ResponseBody
    public Long addStudent(AddStudentReq req) {
        return studentService.addStudent(req);
    }


    @RequestMapping("/add")
    @ResponseBody
    public Long addStudent(Long req) {
        if (req.equals(1L)) {

            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        } else if (req.equals(2L)) {
            throw new GenericJDBCException("xxx", new SQLException());
        } else {
            throw new RuntimeException();
        }
    }
}
