package dev.jlkeesh.papertrade.configs;

import dev.jlkeesh.papertrade.configs.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author : Elmurodov Javohir
 * @since : 18/07/23 / 09:25
 */

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaAuditConfig {

    private final CurrentUser currentUser;

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(currentUser.userID());
    }

}
