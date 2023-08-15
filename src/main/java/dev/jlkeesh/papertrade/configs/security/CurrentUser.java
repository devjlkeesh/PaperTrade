package dev.jlkeesh.papertrade.configs.security;

import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.AccessDeniedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import uz.yt.ramsservice.dtos.main.auth.CurrentUserDetailsDto;
import uz.yt.ramsservice.dtos.main.key.CertificateInfoLocal;
import uz.yt.ramsservice.enums.ErrorCode;
import uz.yt.ramsservice.exceptions.AccessDeniedException;
import uz.yt.ramsservice.exceptions.BadRequestException;

import java.io.IOException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrentUser {

    private final HttpServletRequest request;


    public Object userID() {
        return getUser().getId();
    }

    public String getLang() {
        return request.getHeader("Accept-Language");
    }


    public Object getUser() {
        var securityContext = checkContext();
        var authentication = checkAuthentication(securityContext);
        return checkPrincipal(authentication);
    }


    private Object checkPrincipal(Authentication authentication) {
        var principal = authentication.getPrincipal();
        if (principal instanceof UserDetails)
            return principal;
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
