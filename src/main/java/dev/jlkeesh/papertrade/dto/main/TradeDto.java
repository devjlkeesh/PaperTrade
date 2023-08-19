package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.main.CustomerDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Trade}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeDto implements Dto {
    private Long id;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private CustomerDto customer;
    private TradeStatusDto tradeStatus;
    private String note;
}