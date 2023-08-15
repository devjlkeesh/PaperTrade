package dev.jlkeesh.papertrade;

import dev.jlkeesh.papertrade.property.CorsProperty;
import dev.jlkeesh.papertrade.property.RSAKeyPairs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        RSAKeyPairs.class,
        CorsProperty.class
})
public class PaperTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperTradeApplication.class, args);
    }

}
