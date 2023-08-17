package dev.jlkeesh.papertrade.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;

import static org.zalando.logbook.core.Conditions.*;

/**
 * @author : Elmurodov Javohir
 * @since : 18/07/23 / 08:50
 */
@Configuration
public class LogbookConfig {

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .condition(exclude(
                        requestTo("/v3/api-docs"),
                        requestTo("/v3/api-docs/swagger-config"),
                        requestTo("/swagger-ui.html"),
                        requestTo("/swagger-ui/**"),
                        requestTo("/api/auth/**"),
                        contentType("application/octet-stream")
                        /*header("X-Secret", newHashSet("1", "true")::contains)*/))
                .build();
    }

}
