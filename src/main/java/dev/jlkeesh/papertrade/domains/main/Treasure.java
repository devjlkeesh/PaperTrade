package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 21:34
 */

@Getter
@Setter
@Entity
public class Treasure extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "treasure_source_id")
    private TreasureSource treasureSource;

    @Column(nullable = false, columnDefinition = "numeric(20 , 2)")
    private Double inSum;

    @Column(nullable = false, columnDefinition = "numeric(20 , 2)")
    private Double remSum;

    @Column(nullable = false, columnDefinition = "numeric(20 , 2)")
    private Double outSum;

    @OneToOne
    @JoinColumn(nullable = false, name = "curreny_id")
    private Currency currency;

  /*  CustomerP in_customer_payment_id int(9) [ref:>customer_payments.id]
    out_expense_id

    int(9) [ref:>expenses.id]

    note nvarchar(200)

    register_date timestamp*/
}
