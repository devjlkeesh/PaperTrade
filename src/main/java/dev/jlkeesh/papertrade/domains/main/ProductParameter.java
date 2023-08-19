package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Parameter;
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
public class ProductParameter extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(nullable = false, name = "parameter_id")
    private Parameter parameter;

    @Column(nullable = false)
    private String value;

}
