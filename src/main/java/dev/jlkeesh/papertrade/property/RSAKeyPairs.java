package dev.jlkeesh.papertrade.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author : Elmurodov Javohir
 * @since : 05/07/23 / 10:43
 */
@ConfigurationProperties(prefix = "rsa")
public record RSAKeyPairs(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
}
