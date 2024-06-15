package com.sut.school.service.impl;

import com.sut.school.entity.Score;
import com.sut.school.repository.ScoreRepository;
import com.sut.school.service.ScoreService;
import com.sut.school.web.reqRes.AddScoreReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreRepository scoreRepository;

    @Override
    public List<Score> listScore() {return scoreRepository.findAll();}

    @Override
    public long addScore(AddScoreReq addScoreReq) {
        Score score = new Score();
        score.setStudentId(addScoreReq.getStudentId());
        score.setCourseId(addScoreReq.getCourseId());
        score.setScore(addScoreReq.getScore());
        return scoreRepository.save(score).getId();
    }

    @Override
    public void deleteScore(long id) {scoreRepository.deleteById(id);}

    @Override
    public List<Score> getScoresByStudentId(Long studentId) {
        return scoreRepository.findByStudentId(studentId);
    }

    @Override
    public void saveScores(Long studentId, List<Score> scores) {
        for (Score score : scores) {
            score.setStudentId(studentId);
            scoreRepository.save(score);
        }
    }
}
