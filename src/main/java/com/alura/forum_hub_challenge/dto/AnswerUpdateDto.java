package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.entity.Answer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Answer}
 */
public record AnswerUpdateDto(
        @NotNull(message = "É necessário informar o id da resposta.")
        Long id,

        @NotBlank(message = "A mensagem não pode estar em branco.")
        String message
) implements Serializable {
}
