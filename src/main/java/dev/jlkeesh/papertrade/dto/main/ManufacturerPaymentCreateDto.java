package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.ManufacturerPayment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerPaymentCreateDto implements Dto {
    @NotNull
    private String name;
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private Double credit;
    @NotNull
    private Double debit;
    @NotNull
    private String note;
    @NotNull
    private Double otherCredit;
    @NotNull
    private Double otherDebit;
    @NotNull
    private LocalDateTime registerDate;
    @NotNull
    private Long currencyId;
    @NotNull
    private Long countryId;
    @NotNull
    private Long manufacturerId;
    @NotNull
    private Long orderWagonId;
    @NotNull
    private Long consigneeId;
}