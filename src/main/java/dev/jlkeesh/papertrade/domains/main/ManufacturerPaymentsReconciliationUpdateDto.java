package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link ManufacturerPaymentsReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerPaymentsReconciliationUpdateDto implements Dto {
    @NotNull
    private Long id;
    private PaymentType paymentType;
    private Double deposit;
    private Double credit;
    private String note;
    private Double debit;
    private Double otherDeposit;
    private Double otherCredit;
    private Double otherDebit;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
}