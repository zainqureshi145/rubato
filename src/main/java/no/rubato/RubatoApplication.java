package no.rubato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "no.rubato.repository")
@SpringBootApplication
public class RubatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubatoApplication.class, args);
    }

}
