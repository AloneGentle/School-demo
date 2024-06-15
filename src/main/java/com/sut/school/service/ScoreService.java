package com.sut.school.service;

import com.sut.school.entity.Score;
import com.sut.school.web.reqRes.AddScoreReq;

import java.util.List;

public interface ScoreService {

    List<Score> listScore();

    long addScore(AddScoreReq score);

    void deleteScore(long id);

    List<Score> getScoresByStudentId(Long studentId);

    void saveScores(Long studentId, List<Score> scores);

}
