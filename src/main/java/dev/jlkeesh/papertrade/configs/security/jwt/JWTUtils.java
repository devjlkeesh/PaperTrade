package dev.jlkeesh.papertrade.configs.security.jwt;

import dev.jlkeesh.papertrade.property.RSAKeyPairs;
import dev.jlkeesh.papertrade.dto.Tuple2;
import dev.jlkeesh.papertrade.dto.auth.TokenDto;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.Type;
import dev.jlkeesh.papertrade.exceptions.AuthorizedException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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


@Component
@RequiredArgsConstructor
public class JWTUtils {
    private final RSAKeyPairs keyPairs;
    private final Environment env;

    public TokenDto generateToken(@NonNull String serialNumber, @NonNull Type type) throws JoseException {
        long expiresAt = System.currentTimeMillis() + getTokenExpiryTimeInMillisecondsByTokenType(type);

        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setIssuer("yt.uz");
        jwtClaims.setAudience("yt.uz");
        jwtClaims.setExpirationTime(NumericDate.fromMilliseconds(expiresAt));
        jwtClaims.setGeneratedJwtId();
        jwtClaims.setIssuedAtToNow();
        jwtClaims.setSubject(serialNumber);
        jwtClaims.setClaim("type", type);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(jwtClaims.toJson());
        jws.setKey(keyPairs.privateKey());
        jws.setKeyIdHeaderValue(UUID.randomUUID().toString());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        return new TokenDto(jws.getCompactSerialization(), expiresAt);
    }

    public Tuple2<String, Type> validateAndGetSubjectAndTokenType(@NonNull String token) {
        try {
            JwtConsumer jwtConsumer = buildJwtConsumer();
            JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
            String subject = jwtClaims.getSubject();
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
                .setExpectedIssuer("yt.uz")
                .setExpectedAudience("yt.uz")
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
