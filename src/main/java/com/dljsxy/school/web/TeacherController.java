package com.dljsxy.school.web;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.entity.Teacher;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.service.TeacherService;
import com.dljsxy.school.web.reqRes.AddTeacherReq;
import com.dljsxy.school.web.reqRes.BaseApiRes;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/add-teacher")
    public Long addTeacher(AddTeacherReq req) {
        return teacherService.addTeacher(req);
    }

    @RequestMapping("/add")
    public Long addTeacher(Long req) {
        if (req.equals(1L)) {

            throw new WebApiException(WebExceptionEnum.PARAM_ERROR);
        } else if (req.equals(2L)) {
            throw new GenericJDBCException("xxx", new SQLException());
        } else {
            throw new RuntimeException();
        }
    }

    @RequestMapping("/list")
    public BaseApiRes<List<Teacher>> listTeacher(Long req) {
        var ret = new BaseApiRes<List<Teacher>>();
        ret.setData(teacherService.listTeacher());
        return ret;
    }
}
