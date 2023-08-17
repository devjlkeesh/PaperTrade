package dev.jlkeesh.papertrade.domains.auth;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 08:49
 */

@Entity
@Getter
@Setter
public class AuthRole extends Auditable {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    public GrantedAuthority getAuthority() {
        return new SimpleGrantedAuthority("ROLE_" + this.code);
    }

}
