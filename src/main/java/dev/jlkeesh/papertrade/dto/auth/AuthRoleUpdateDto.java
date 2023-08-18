package dev.jlkeesh.papertrade.dto.auth;

import dev.jlkeesh.papertrade.domains.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_BLANK;
import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_NULL;

/**
 * DTO for {@link AuthRole}
 */
@Getter
@Setter
public class AuthRoleUpdateDto implements Dto {
    @NotNull(message = INPUT_CANNOT_BE_NULL)
    private Long id;
    private  String code;
    private String name;
}