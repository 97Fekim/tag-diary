package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.dto.TagDTO;
import com.fekim.tagdiary.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log4j2
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TagService tagService;

    @PostMapping("/api/test")
    public TagDTO testApi(){

        return tagService.getMostPopularTag("emotion");

    }
}
