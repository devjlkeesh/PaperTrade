package dev.jlkeesh.papertrade.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.yt.ramsservice.configs.security.CurrentUser;

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
    public AuditorAware<Object> auditorAware() {
        return () -> Optional.of(currentUser.userID());
    }

}
