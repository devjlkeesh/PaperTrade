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
public class ManufacturerPaymentUpdateDto implements Dto {
    @NotNull
    private Long id;
    private String name;
    private PaymentType paymentType;
    private Double credit;
    private Double debit;
    private String note;
    private Double otherCredit;
    private Double otherDebit;
    private LocalDateTime registerDate;
    private Long currencyId;
    private Long countryId;
    private Long manufacturerId;
    private Long orderWagonId;
    private Long consigneeId;
}