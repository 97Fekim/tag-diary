package com.fekim.tagdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TagDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagDiaryApplication.class, args);
    }

}
