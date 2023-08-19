package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.TradeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 22:06
 */

@Getter
@Setter
@Entity
public class Trade  extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(nullable = false, name = "trade_status_id")
    private TradeStatus tradeStatus;

    @Column(nullable = false)
    private String note;
}
