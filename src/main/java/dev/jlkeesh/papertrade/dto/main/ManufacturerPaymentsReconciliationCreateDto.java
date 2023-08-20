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
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerPaymentsReconciliationCreateDto implements Dto {
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private Double deposit;
    @NotNull
    private Double credit;
    @NotNull
    private String note;
    @NotNull
    private Double debit;
    @NotNull
    private Double otherDeposit;
    @NotNull
    private Double otherCredit;
    @NotNull
    private Double otherDebit;
    @NotNull
    private LocalDateTime beginDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    private Long manufacturerId;
    @NotNull
    private Long consigneeId;
    @NotNull
    private Long currencyId;
}