package com.alura.forum_hub_challenge.dto;

import com.alura.forum_hub_challenge.controller.AuthenticationController;

import java.io.Serializable;

/**
 * DTO for {@link AuthenticationController}
 */
public record JwtTokenDto(String token) implements Serializable {
}
