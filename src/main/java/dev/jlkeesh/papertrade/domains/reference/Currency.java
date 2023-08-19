package dev.jlkeesh.papertrade.domains.reference;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:15
 */

@Entity
@Getter
@Setter
public class Currency extends Auditable {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double value;
}
