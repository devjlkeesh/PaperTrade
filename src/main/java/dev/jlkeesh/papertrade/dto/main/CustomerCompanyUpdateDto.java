package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.CustomerCompany}
 */
public record CustomerCompanyUpdateDto(@NotNull Long id, String name, State state, Long customerId) implements Dto {
}