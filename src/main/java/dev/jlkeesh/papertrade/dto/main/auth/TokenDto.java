package dev.jlkeesh.papertrade.dto.main.auth;

public record TokenDto(String token, Long expiresAt) {
}
