package com.sut.school.web;

import com.sut.school.entity.Student;
import com.sut.school.service.StudentService;
import com.sut.school.web.reqRes.AddStudentReq;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public BaseApiRes<List<Student>> listStudent() {
        BaseApiRes<List<Student>> ret = new BaseApiRes<>();
        ret.setData(studentService.listStudent());
        return ret;
    }

    @PostMapping("/add-student")
    public long addStudent(@RequestBody AddStudentReq addStudentReq) {
        return studentService.addStudent(addStudentReq);
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update-student/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody AddStudentReq updateStudentReq) {
        studentService.updateStudent(id, updateStudentReq);
    }
}
