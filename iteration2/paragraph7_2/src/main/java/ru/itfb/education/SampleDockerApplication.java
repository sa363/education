package ru.itfb.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SampleDockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleDockerApplication.class, args);
    }
}
