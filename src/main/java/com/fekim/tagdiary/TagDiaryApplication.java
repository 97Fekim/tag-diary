package com.fekim.tagdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class TagDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagDiaryApplication.class, args);
    }

}
