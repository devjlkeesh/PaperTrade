package dev.jlkeesh.papertrade.dto.auth;

import jakarta.validation.constraints.NotNull;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_BLANK;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:46
 */
public record GetTokenRequest(@NotNull(message = INPUT_CANNOT_BE_BLANK) String username, @NotNull(message = INPUT_CANNOT_BE_BLANK) String password) { }
