package dev.jlkeesh.papertrade.dto.main.auth;

import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO for {@link AuthRole}
 */
@Getter
@Setter
public class AuthRoleDto implements Dto {
    private Long id;
    private String code;
    private String name;
    private LocalDateTime createdAt;
    private Long createdBy;
}