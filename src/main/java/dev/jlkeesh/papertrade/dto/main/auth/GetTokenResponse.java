package dev.jlkeesh.papertrade.dto.main.auth;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:46
 */
public record GetTokenResponse(TokenDto access, TokenDto refresh) {
}
