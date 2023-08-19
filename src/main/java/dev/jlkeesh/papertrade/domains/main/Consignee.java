package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:49
 */

@Entity
@Getter
@Setter
public class Consignee extends Auditable {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;
}
