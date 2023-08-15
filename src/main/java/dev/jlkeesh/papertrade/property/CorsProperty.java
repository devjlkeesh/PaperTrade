package dev.jlkeesh.papertrade.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 03/07/23 / 11:31
 */


@Getter
@Setter
@ConfigurationProperties(prefix = "cors")
public class CorsProperty {
    private List<String> allowedHeaders;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> exposedHeaders;
    private String urlPattern;
    private boolean allowCredentials;
}
