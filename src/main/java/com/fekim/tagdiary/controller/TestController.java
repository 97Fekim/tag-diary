package com.fekim.tagdiary.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/blog-post-template/")
public class TestController {

    @GetMapping("/index")
    public void gotoIndex(){

    }

    @GetMapping("/contact")
    public void gotoContact(){

    }

    @GetMapping("/about")
    public void gotoAbout(){

    }

    @GetMapping("/post")
    public void gotoPost(){

    }

}
