package dev.jlkeesh.papertrade.dto.main.auth;

import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_NULL;

/**
 * DTO for {@link AuthUser}
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