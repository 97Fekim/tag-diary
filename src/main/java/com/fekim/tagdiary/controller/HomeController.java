package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.security.dto.AuthMemberDTO;
import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TagService tagService;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                       Model model){

        TagDTO tagDTO = tagService.getMostPopularTag("emotion");

        log.info("================authMemberDTO : " + authMemberDTO);

        boolean isLogined = authMemberDTO != null;

        model.addAttribute("tagDTO", tagDTO);
        model.addAttribute("isLogined", isLogined);

        return "home";
    }

}
