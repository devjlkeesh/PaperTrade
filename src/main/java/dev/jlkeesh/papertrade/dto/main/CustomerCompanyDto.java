package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.State;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.CustomerCompany}
 */
public record CustomerCompanyDto(Long id, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt,
                                 Long updatedBy, String name, State state,
                                 CustomerDto customer) implements Dto {
}