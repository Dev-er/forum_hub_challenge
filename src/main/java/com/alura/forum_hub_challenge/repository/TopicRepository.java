package com.alura.forum_hub_challenge.repository;

import com.alura.forum_hub_challenge.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Boolean existsByIdAndUserId(Long id, Long userId);
}