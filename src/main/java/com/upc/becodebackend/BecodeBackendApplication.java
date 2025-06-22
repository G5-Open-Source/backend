package com.upc.becodebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BecodeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BecodeBackendApplication.class, args);
    }

}
