package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:49
 */

@Entity
@Getter
@Setter
public class ProductPrice extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double priceMan;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double pricePrime;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double priceSell;

    @Column(nullable = false, columnDefinition = "numeric(5, 2)")
    private Double priceManNds;

}
