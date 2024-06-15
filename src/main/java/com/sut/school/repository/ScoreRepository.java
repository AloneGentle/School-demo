package com.sut.school.repository;

import com.sut.school.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>, JpaSpecificationExecutor<Score> {
    List<Score> findByStudentId(Long studentId);
}
