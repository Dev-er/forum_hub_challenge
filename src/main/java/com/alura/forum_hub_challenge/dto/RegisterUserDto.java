package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.controller.RegisterUserController;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link RegisterUserController}
 */
public record RegisterUserDto(
        @Size(message = "O nome não pode ultrapassar 255 caracteres.", max = 255)
        @NotBlank(message = "O usuário precisar ter um nome.")
        String nickname,

        @NotBlank(message = "Um e-mail válido deve ser informado.")
        @Email(message = "Um e-mail válido deve ser informado.")
        String email,

        @Size(message = "A senha não pode ultrapassar 255 caracteres.", max = 255)
        @NotBlank(message = "A senha não pode estar em branco.")
        String password
) implements Serializable {
}