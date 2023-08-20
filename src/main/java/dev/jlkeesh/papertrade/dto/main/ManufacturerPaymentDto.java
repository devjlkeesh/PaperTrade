package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.enums.PaymentType;
import dev.jlkeesh.papertrade.enums.State;
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
public class ManufacturerPaymentDto implements Dto {
    private Long id;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private String name;
    private State state;
    private CountryDto country;
    private ManufacturerDto manufacturer;
    private OrderWagonDto orderWagon;
    private ConsigneeDto consignee;
    private PaymentType paymentType;
    private Double credit;
    private Double debit;
    private String note;
    private CurrencyDto currency;
    private Double otherCredit;
    private Double otherDebit;
    private LocalDateTime registerDate;
}