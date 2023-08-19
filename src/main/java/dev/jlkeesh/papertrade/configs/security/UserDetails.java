package dev.jlkeesh.papertrade.configs.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * @author : Elmurodov Javohir
 * @since : 15/08/23 / 20:12
 */
@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final Long userId;
    private final AuthUser user;

    public UserDetails(AuthUser user) {
        this.user = user;
        this.userId = user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getRoles().isEmpty())
            return Collections.emptyList();
        return user.getRoles().stream().map(AuthRole::getAuthority).toList();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
