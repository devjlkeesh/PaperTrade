package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.RegionDto;
import dev.jlkeesh.papertrade.enums.State;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.Customer}
 */
public record CustomerDto(Long id, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy,
                          String name, String phone, State state, RegionDto region) implements Dto {
}