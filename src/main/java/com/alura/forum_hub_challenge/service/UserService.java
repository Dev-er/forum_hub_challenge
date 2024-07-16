package com.alura.forum_hub_challenge.service;

import com.alura.forum_hub_challenge.controller.UserController;
import com.alura.forum_hub_challenge.dto.UserUpdateDto;
import com.alura.forum_hub_challenge.entity.User;
import com.alura.forum_hub_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for {@link UserController}
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> list(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User update(UserUpdateDto dto) {
        User user = null;

        if (isUserAuthorized(dto.id())) {
            user = userRepository.findById(dto.id()).orElseThrow();

            if (dto.nickname() != null && !dto.nickname().isBlank()) {
                user.setNickname(dto.nickname());
            }

            if (dto.email() != null && !dto.email().isBlank()) {
                user.setEmail(dto.email());
            }

//            if (usuarioAtualizacaoDto.senha() != null && !usuarioAtualizacaoDto.senha().isBlank()) {
//                var encoder = new BCryptPasswordEncoder();
//                var encodedPassword = encoder.encode(usuarioAtualizacaoDto.senha());
//                usuario.setSenha(encodedPassword);
//            }

            userRepository.save(user);
        }

        return user;
    }

    @Transactional
    public boolean delete(Long id) {
        if (isUserAuthorized(id)) {
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public User detail(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    private boolean isUserAuthorized(Long id) {
        var userToManipulate = userRepository.findById(id).orElseThrow();
        var authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return (long) userToManipulate.getId() == authenticatedUser.getId();
    }
}
