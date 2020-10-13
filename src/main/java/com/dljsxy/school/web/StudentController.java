package com.dljsxy.school.web;

import com.dljsxy.school.entity.Student;
import com.dljsxy.school.service.StudentService;
import com.dljsxy.school.web.reqRes.AddStudentReq;
import com.dljsxy.school.web.reqRes.BaseApiResponse;
import com.dljsxy.school.web.reqRes.GetStudentReq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ningtao
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/info")
    public BaseApiResponse<Student> info(GetStudentReq req) {
        Student student = studentService.getStudentInfoByName(req.getName());
        return new BaseApiResponse<>(student);
    }

    @RequestMapping("/add")
    public Long addStudent(AddStudentReq req) {
        return studentService.addStudent(req);
//        if (req.equals(1L)) {
//
//            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
//        } else if (req.equals(2L)) {
//            throw new GenericJDBCException("xxx", new SQLException());
//        } else {
//            throw new RuntimeException();
//        }
    }
}
