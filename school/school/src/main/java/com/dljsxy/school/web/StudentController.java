package com.dljsxy.school.web;

import com.dljsxy.school.entity.Student;
import com.dljsxy.school.model.StudentModel;
import com.dljsxy.school.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/info")
    public String info(Model mv) {
        StudentModel studentModel = new StudentModel();
        Student student = studentService.getStudentInfoByName("run");
        BeanUtils.copyProperties(student, studentModel);
        mv.addAttribute("studentModel", studentModel);
        return "Hello";
    }


}