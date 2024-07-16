package com.alura.forum_hub_challenge.repository;

import com.alura.forum_hub_challenge.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Boolean existsByIdAndUserId(Long id, Long userId);
}