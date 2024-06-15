package com.sut.school.web;

import com.sut.school.entity.Teacher;
import com.sut.school.service.TeacherService;
import com.sut.school.web.reqRes.AddTeacherReq;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {this.teacherService = teacherService;}

    @GetMapping("/list")
    public BaseApiRes<List<Teacher>> listTeacher(@RequestParam(required = false) String name) {
        var ret = new BaseApiRes<List<Teacher>>();
        if (name == null || name.isEmpty()) {
            ret.setData(teacherService.listTeacher());
        } else {
            ret.setData(teacherService.findTeachersByName(name));
        }
        return ret;
    }

    @PutMapping("/update-teacher/{id}")
    public void updateTeacher(@PathVariable long id, @RequestBody AddTeacherReq updateTeacherReq ) {
        teacherService.updateTeacher(id, updateTeacherReq);
    }

    @DeleteMapping("delete-teacher/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teacherService.deleteTeacher(id);
    }

    @PostMapping("/add-teacher")
    public long addTeacher(@RequestBody AddTeacherReq addTeacherReq) {
        return teacherService.addTeacher(addTeacherReq);
    }



}
