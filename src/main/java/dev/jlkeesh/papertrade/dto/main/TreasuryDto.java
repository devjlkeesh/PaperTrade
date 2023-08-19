package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:40
 */
public record TreasuryDto(Long id,
                          Long treasureSourceId,
                          Long inCustomerPaymentId,
                          Long outExpenseId) implements Dto {
}
