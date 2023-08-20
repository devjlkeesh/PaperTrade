package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 21:38
 */

@Getter
@Setter
@Entity
public class InventoryProductsReconciliation extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "inventory_id")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(nullable = false)
    private Long inWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double inSum;

    @Column(nullable = false)
    private Long remWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double remSum;

    @Column(nullable = false)
    private Long sellWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double sellSum;

    @Column(nullable = false)
    private Long defectWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double defectSum;

    @Column(nullable = false)
    private LocalDate beginDate;

    @Column(nullable = false)
    private LocalDate endDate;
}
