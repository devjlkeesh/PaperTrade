package dev.jlkeesh.papertrade.dto.auth;

import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link AuthUser}
 */
@Getter
@Setter
public class AuthUserDto implements Dto {
    private Long id;
    private String fullName;
    private String username;
    private String phone;
    private List<AuthRoleDto> roles;
    private LocalDateTime createdAt;
    private Long createdBy;
}