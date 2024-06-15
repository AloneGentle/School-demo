package com.sut.school.web;

import com.sut.school.entity.Course;
import com.sut.school.entity.Score;
import com.sut.school.entity.Student;
import com.sut.school.repository.CourseRepository;
import com.sut.school.repository.StudentRepository;
import com.sut.school.service.ScoreService;
import com.sut.school.web.reqRes.BaseApiRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private final ScoreService scoreService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public ScoreController(ScoreService scoreService) {this.scoreService = scoreService;}

    @GetMapping("/scores/list")
    public BaseApiRes<List<Score>> listScore() {
        BaseApiRes<List<Score>> ret = new BaseApiRes<>();
        ret.setData(scoreService.listScore());
        return ret;
    }

    @GetMapping("/students/list")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{studentId}/courses")
    public List<Course> getStudentCourses(@PathVariable Long studentId) {
        // 这里假设所有课程都需要返回
        return courseRepository.findAll();
    }

    @PostMapping("/scores/add-score")
    public void addOrUpdateScores(@RequestParam Long studentId, @RequestBody List<Score> scores) {
        scoreService.saveScores(studentId, scores);
    }


//    @PostMapping("/add-score")
//    public long addScore(@RequestBody AddScoreReq addScoreReq ) {return scoreService.addScore(addScoreReq);}

//    @DeleteMapping("/delete-score/{id}")
//    public void deleteStudent(@PathVariable long id){scoreService.deleteScore(id);}
}
