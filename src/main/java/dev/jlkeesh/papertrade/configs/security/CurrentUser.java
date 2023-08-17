package dev.jlkeesh.papertrade.configs.security;

import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.AccessDeniedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrentUser {

    private final HttpServletRequest request;

    public Long userID() {
        return getUser().getUserId();
    }

    public String getLang() {
        return request.getHeader("Accept-Language");
    }


    public UserDetails getUser() {
        var securityContext = checkContext();
        var authentication = checkAuthentication(securityContext);
        return checkPrincipal(authentication);
    }


    private UserDetails checkPrincipal(Authentication authentication) {
        var principal = authentication.getPrincipal();
        if (principal instanceof UserDetails o) return o;
        throw new AccessDeniedException(ErrorCode.AUTH_UNAUTHORIZED);
    }

    private Authentication checkAuthentication(SecurityContext securityContext) {
        var authentication = securityContext.getAuthentication();
        if (authentication == null || !authentication.isAuthenticated())
            throw new AccessDeniedException(ErrorCode.AUTH_UNAUTHORIZED);
        return authentication;
    }

    private SecurityContext checkContext() {
        var securityContext = SecurityContextHolder.getContext();
        if (securityContext == null)
            throw new AccessDeniedException(ErrorCode.AUTH_UNAUTHORIZED);
        return securityContext;
    }
}
