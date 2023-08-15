package dev.jlkeesh.papertrade.configs.security.filter;

import dev.jlkeesh.papertrade.configs.security.jwt.JWTUtils;
import dev.jlkeesh.papertrade.enums.Type;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Elmurodov Javohir
 * @since : 05/07/23 / 12:42
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authorization = request.getHeader("Authorization");
        if (hasToken(authorization)) doFilter(getToken(authorization));
        filterChain.doFilter(request, response);
    }

    private boolean hasToken(String authorization) {
        return StringUtils.hasText(authorization) && authorization.startsWith("Bearer ");
    }

    private String getToken(@NonNull String authorization) {
        return authorization.substring(7);
    }

    public void doFilter(String token) {
        final var dto = jwtUtils.validateAndGetSubjectAndTokenType(token);
        if (Objects.nonNull(dto) && Type.ACCESS.equals(dto.t2())) {
            String userId = dto.t1();
            UserDetails userDetails = User.builder().username("john").password("123").roles("ADMIN").build(); // TODO: 15/08/23 call redis here
            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
