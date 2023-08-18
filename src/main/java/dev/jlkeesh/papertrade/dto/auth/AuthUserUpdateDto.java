package dev.jlkeesh.papertrade.dto.auth;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_NULL;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.auth.AuthUser}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserUpdateDto implements Dto {
    @NotNull(message = INPUT_CANNOT_BE_NULL)
    private Long id;
    private String fullName;
    private String username;
    private String phone;
}