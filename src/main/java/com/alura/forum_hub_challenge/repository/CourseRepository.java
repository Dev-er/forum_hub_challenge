package com.alura.forum_hub_challenge.repository;

import com.alura.forum_hub_challenge.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findFirstByName(String name);
}