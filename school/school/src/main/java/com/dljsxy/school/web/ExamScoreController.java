package com.dljsxy.school.web;

import com.dljsxy.school.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamScoreController {

    @RequestMapping("/hello2")
    public String hello(Model mv) {
        StudentModel studentModel = new StudentModel();
//        user.setName("nt");
        mv.addAttribute("user", studentModel);
        return "Hello";
    }


}
