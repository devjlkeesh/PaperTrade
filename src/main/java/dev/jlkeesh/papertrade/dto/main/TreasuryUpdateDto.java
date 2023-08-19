package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:40
 */
public record TreasuryUpdateDto(Long id,
                                Long treasureSourceId,
                                BigDecimal inSum,
                                BigDecimal remSum,
                                BigDecimal outSum,
                                Long currencyId,
                                Long inCustomerPaymentId,
                                Long outExpenseId,
                                String note) implements Dto {
}
