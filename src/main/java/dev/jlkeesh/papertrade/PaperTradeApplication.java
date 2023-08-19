package dev.jlkeesh.papertrade;

import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.property.CorsProperty;
import dev.jlkeesh.papertrade.property.RSAKeyPairs;
import dev.jlkeesh.papertrade.repository.main.auth.AuthRoleRepository;
import dev.jlkeesh.papertrade.repository.main.auth.AuthUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({
        RSAKeyPairs.class,
        CorsProperty.class
})
public class PaperTradeApplication {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthRoleRepository authRoleRepository;

    public PaperTradeApplication(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder,
                                 AuthRoleRepository authRoleRepository) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authRoleRepository = authRoleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PaperTradeApplication.class, args);
    }

    //    @Bean
    ApplicationRunner applicationRunner() {
        return (args) -> {
            AuthRole authRole = new AuthRole();
            authRole.setName("Admin");
            authRole.setCode("ADMIN");
            authRole.setCreatedBy(-1L);
            authRole.setUpdatedBy(-1L);


            AuthUser admin = new AuthUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setPhone("+998908115225");
            admin.setCreatedBy(-1L);
            admin.setUpdatedBy(-1L);
            admin.setRoles(List.of(authRole));
            authUserRepository.save(admin);
        };
    }

}
