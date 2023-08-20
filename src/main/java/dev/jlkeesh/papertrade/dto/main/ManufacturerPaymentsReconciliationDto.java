package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.function.FailableToDoubleBiFunction;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerPaymentsReconciliationDto implements Dto {
    private Long id;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private ManufacturerDto manufacturer;
    private ConsigneeDto consignee;
    private PaymentType paymentType;
    private CurrencyDto currency;
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