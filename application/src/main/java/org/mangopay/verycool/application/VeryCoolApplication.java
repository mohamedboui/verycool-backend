package org.mangopay.verycool.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.mangopay.verycool")
@EnableJpaRepositories(basePackages = "org.mangopay.verycool.dataprovider.repository")
@EntityScan(basePackages = "org.mangopay.verycool.dataprovider.model")
public class VeryCoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeryCoolApplication.class, args);
    }

}
