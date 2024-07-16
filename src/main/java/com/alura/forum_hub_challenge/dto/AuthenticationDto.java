package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.controller.AuthenticationController;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link AuthenticationController}
 */
public record AuthenticationDto(
        @NotBlank(message = "Um email válido precisa ser informado.")
        String email,
        @NotBlank(message = "Uma senha precisa ser informada.")
        String password
) implements Serializable {
}
