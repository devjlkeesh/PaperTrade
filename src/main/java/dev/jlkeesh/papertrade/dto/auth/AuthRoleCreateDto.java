package dev.jlkeesh.papertrade.dto.auth;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.auth.AuthRole}
 */
@Getter
@Setter
public class AuthRoleCreateDto implements Dto {
    @NotBlank(message = ErrorCode.INPUT_CANNOT_BE_BLANK)
    private String code;
    @NotBlank(message = ErrorCode.INPUT_CANNOT_BE_BLANK)
    private String name;

    public void upperCase() {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
    }
}