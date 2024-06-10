package com.sut.school.web;

import com.sut.school.entity.Teacher;
import com.sut.school.service.TeacherService;
import com.sut.school.web.reqRes.AddTeacherReq;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add-teacher")
    public long addTeacher(@RequestBody AddTeacherReq addTeacherReq) {
        return teacherService.addTeacher(addTeacherReq);
    }

    @DeleteMapping("delete-teacher/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teacherService.deleteTeacher(id);
    }

    @RequestMapping("/list")
    public BaseApiRes<List<Teacher>> listTeacher() {
        var ret = new BaseApiRes<List<Teacher>>();
        ret.setData(teacherService.listTeacher());
        return ret;
    }
}
