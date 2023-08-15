package dev.jlkeesh.papertrade.dto.auth;

public record TokenDto(String token, Long expiresAt) {
}
