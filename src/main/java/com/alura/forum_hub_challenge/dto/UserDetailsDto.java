package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.User;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserDetailsDto(
        @NotNull(message = "Um id válido precisa ser informado.")
        Long id,
        String nickname,
        String email
) implements Serializable {
    public UserDetailsDto(User user) {
        this(
                user.getId(),
                user.getNickname(),
                user.getEmail()
        );
    }
}
