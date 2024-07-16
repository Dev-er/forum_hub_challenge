package com.alura.forum_hub_challenge.repository;

import com.alura.forum_hub_challenge.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByName(String user);
}