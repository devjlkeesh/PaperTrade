package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.ProductParameter;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link ProductParameter}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParameterUpdateDto implements Dto {
    @NotNull
    private Long id;
    @NotBlank
    private String value;

}