package dev.jlkeesh.papertrade.dto.main.auth;

import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_NULL;

/**
 * DTO for {@link AuthRole}
 */
@Getter
@Setter
public class AuthRoleUpdateDto implements Dto {
    @NotNull(message = INPUT_CANNOT_BE_NULL)
    private Long id;
    private String code;
    private String name;
}