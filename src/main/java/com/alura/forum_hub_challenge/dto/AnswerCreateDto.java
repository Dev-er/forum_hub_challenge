package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.Answer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Answer}
 */
public record AnswerCreateDto(
        @NotNull(message = "Informe o id do tópico onde a resposta será criada.")
        Long topicId,

        @NotBlank(message = "É preciso informar o texto da resposta.")
        String message
) implements Serializable {
}
