package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.dto.TagDTO;
import com.fekim.tagdiary.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TagService tagService;

    @GetMapping("/")
    public String home(Model model){

        TagDTO tagDTO = tagService.getMostPopularTag("emotion");

        model.addAttribute("tagDTO", tagDTO);

        return "home";
    }

}
