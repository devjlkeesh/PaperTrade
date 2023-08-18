package dev.jlkeesh.papertrade.dto.auth;

import dev.jlkeesh.papertrade.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.auth.AuthRole}
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