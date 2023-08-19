package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.CustomerCompany}
 */
public record CustomerCompanyCreateDto(String name, Long customerId) implements Dto {
}