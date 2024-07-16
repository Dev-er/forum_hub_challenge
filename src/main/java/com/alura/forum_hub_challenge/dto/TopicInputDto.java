package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Topic}
 */
public record TopicInputDto(
        @Size(message = "O título deve ter no máximo 255 caracteres.", max = 255)
        @NotBlank(message = "O título não pode estar em branco.")
        String title,

        @Size(message = "O tópico não pode ter mais de 255 caracteres.", max = 255)
        @NotBlank(message = "O tópico não pode estar em branco.")
        String message,

        @NotNull(message = "O tópico precisa pertencer a algum curso")
        CourseDto course
) implements Serializable {
}
