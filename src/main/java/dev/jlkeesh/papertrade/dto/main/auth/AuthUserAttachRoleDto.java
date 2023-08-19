package dev.jlkeesh.papertrade.dto.main.auth;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 21:47
 */
public record AuthUserAttachRoleDto(Long userId, List<Long> roles) {
}
