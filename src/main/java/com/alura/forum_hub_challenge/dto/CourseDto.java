package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Course}
 */
public record CourseDto(
        @Size(message = "O nome não pode ultrapassar 255 caracteres.", max = 255)
        @NotBlank(message = "O curso precisa ter algum nome.")
        String name,

        @Size(message = "A categoria não pode ultrapassar 255 caracteres.", max = 255)
        String category
) implements Serializable {
}
