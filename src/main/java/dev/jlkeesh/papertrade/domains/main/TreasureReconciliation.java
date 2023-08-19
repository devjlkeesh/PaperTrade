package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:49
 */

@Entity
@Getter
@Setter
public class TreasureReconciliation extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "treasure_source_id")
    private TreasureSource treasureSource;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double inSum;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double remSum;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double outSum;

    @OneToOne
    @JoinColumn(nullable = false, name = "currency_id")
    private Currency currency;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private LocalDateTime beginDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

}
