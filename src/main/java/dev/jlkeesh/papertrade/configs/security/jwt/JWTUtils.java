package dev.jlkeesh.papertrade.configs.security.jwt;

import dev.jlkeesh.papertrade.dto.Tuple2;
import dev.jlkeesh.papertrade.dto.main.auth.TokenDto;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.Type;
import dev.jlkeesh.papertrade.exceptions.AuthorizedException;
import dev.jlkeesh.papertrade.property.RSAKeyPairs;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class JWTUtils {
    private final RSAKeyPairs keyPairs;
    private final Environment env;

    public TokenDto generateToken(Long id, Type type) {
        try {
            long expiresAt = System.currentTimeMillis() + getTokenExpiryTimeInMillisecondsByTokenType(type);
            JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer("not_specified");
            jwtClaims.setAudience("not_specified");
            jwtClaims.setExpirationTime(NumericDate.fromMilliseconds(expiresAt));
            jwtClaims.setGeneratedJwtId();
            jwtClaims.setIssuedAtToNow();
            jwtClaims.setSubject(String.valueOf(id));
            jwtClaims.setClaim("type", type);

            JsonWebSignature jws = new JsonWebSignature();
            jws.setPayload(jwtClaims.toJson());
            jws.setKey(keyPairs.privateKey());
            jws.setKeyIdHeaderValue(UUID.randomUUID().toString());
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

            return new TokenDto(jws.getCompactSerialization(), expiresAt);
        } catch (JoseException e) {
            log.error("JoseException : {}", e.getMessage(), e);
            throw new AuthorizedException(ErrorCode.AUTH_BAD_CREDENTIALS);
        }
    }

    public Tuple2<Long, Type> validateAndGetSubjectAndTokenType(@NonNull String token) {
        try {
            JwtConsumer jwtConsumer = buildJwtConsumer();
            JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
            Long subject = Long.parseLong(jwtClaims.getSubject());
            String type = jwtClaims.getClaimValue("type", String.class);
            return new Tuple2<>(subject, Type.valueOf(type));
        } catch (InvalidJwtException | MalformedClaimException e) {
            throw new AuthorizedException(ErrorCode.AUTH_UNAUTHORIZED, e);
        }
    }

    private JwtConsumer buildJwtConsumer() {
        return new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setRequireSubject()
                .setExpectedIssuer("not_specified")
                .setExpectedAudience("not_specified")
                .setVerificationKey(keyPairs.publicKey())
                .setJwsAlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
                .build();
    }

    private long getTokenExpiryTimeInMillisecondsByTokenType(@NotNull Type type) {
        return switch (type) {
            case ACCESS -> env.getRequiredProperty("jwt.accessTokenExpiresIn", Long.class);
            case REFRESH -> env.getRequiredProperty("jwt.refreshTokenExpiresIn", Long.class);
        };
    }

}
