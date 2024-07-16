package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserUpdateDto(
        @NotNull(message = "Um id válido precisa ser informado.")
        Long id,

        @NotBlank(message = "Um nickname precisa ser informado.")
        String nickname,

        @NotBlank(message = "Um e-mail válido deve ser informado.")
        @Email(message = "Um e-mail válido deve ser informado.")
        String email
//        @NotNull()
//        String senha
) implements Serializable {
}
