package com.alura.forum_hub_challenge.service;

import com.alura.forum_hub_challenge.controller.RegisterUserController;
import com.alura.forum_hub_challenge.dto.RegisterUserDto;
import com.alura.forum_hub_challenge.entity.User;
import com.alura.forum_hub_challenge.repository.ProfileRepository;
import com.alura.forum_hub_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for {@link RegisterUserController}
 */
@Service
public class RegisterUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    public User register(RegisterUserDto dto) {
        var userProfile = profileRepository.findByName("user");
        var user = new User();
        var encoder = new BCryptPasswordEncoder();
        var encodedPassword = encoder.encode(dto.password());

        user.addProfile(userProfile);
        user.setNickname(dto.nickname());
        user.setEmail(dto.email());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return user;
    }
}
