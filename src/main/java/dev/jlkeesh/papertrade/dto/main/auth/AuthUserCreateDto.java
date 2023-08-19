package dev.jlkeesh.papertrade.dto.main.auth;

import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_CANNOT_BE_BLANK;
import static dev.jlkeesh.papertrade.enums.ErrorCode.INPUT_INVALID;

/**
 * DTO for {@link AuthUser}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDto implements Dto {
    @NotBlank(message = INPUT_CANNOT_BE_BLANK)
    private String fullName;
    @NotBlank(message = INPUT_CANNOT_BE_BLANK)
    private String username;
    @NotBlank(message = INPUT_CANNOT_BE_BLANK)
    private String password;
    @Pattern(regexp = "\\+\\d{12}", message = INPUT_INVALID)
    private String phone;
}