package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.ProductParameter;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.ParameterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link ProductParameter}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParameterDto implements Dto {
    private Long id;
    private ProductDto product;
    private ParameterDto parameter;
    private String value;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}