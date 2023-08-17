package dev.jlkeesh.papertrade.configs.security;

import dev.jlkeesh.papertrade.configs.security.filter.AuthenticationFilter;
import dev.jlkeesh.papertrade.property.CorsProperty;
import dev.jlkeesh.papertrade.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.PrintWriter;

/**
 * @author : Elmurodov Javohir
 * @since : 01/07/23 / 13:20
 */


@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
public class SecurityConfig {
    private final CorsProperty corsProperty;
    private final AuthenticationFilter authenticationFilter;

    private static final String[] WHITE_LIST = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/swagger-config",
            "/actuator/health",
            "/actuator/health/**",
            "/api/auth/get-token"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(httpReq -> httpReq
                        .requestMatchers(WHITE_LIST)
                        .permitAll()
                        .anyRequest()
                        .fullyAuthenticated())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionConfig -> exceptionConfig
                        .accessDeniedHandler(getAccessDeniedHandler())
                        .authenticationEntryPoint(getAuthenticationEntryPoint()))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> null;
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return urlBasedCorsConfigurationSource();
    }

    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(urlBasedCorsConfigurationSource());
    }

    private UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getUrlPattern(), buildConfig());
        return source;
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(corsProperty.getAllowedHeaders());
        corsConfiguration.setAllowedOrigins(corsProperty.getAllowedOrigins());
        corsConfiguration.setAllowedMethods(corsProperty.getAllowedMethods());
        corsConfiguration.setAllowCredentials(corsProperty.isAllowCredentials());
        corsConfiguration.setExposedHeaders(corsProperty.getExposedHeaders());
        return corsConfiguration;
    }

    private AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return (request, response, e) -> {
            log.error("Unauthorized", e);
            PrintWriter writer = response.getWriter();
            response.setStatus(401);
            writer.write("Unauthorized");
            writer.flush();
        };
    }

    private AccessDeniedHandler getAccessDeniedHandler() {
        return (request, response, e) -> {
            log.error("AccessDeniedException", e);
            PrintWriter writer = response.getWriter();
            response.setStatus(403);
            writer.write("Forbidden");
            writer.flush();
        };
    }
}
