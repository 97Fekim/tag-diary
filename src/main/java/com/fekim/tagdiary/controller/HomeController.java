package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.security.dto.AuthMemberDTO;
import com.fekim.tagdiary.diary.dto.PageRequestDTO;
import com.fekim.tagdiary.diary.dto.PageResultDTO;
import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.diary.service.DiaryService;
import com.fekim.tagdiary.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TagService tagService;

    private final DiaryService diaryService;

    @GetMapping("/")
    public String home(Model model){

        TagDTO tagDTO = tagService.getMostPopularTag("emotion");

        model.addAttribute("tagDTO", tagDTO);

        return "home";
    }

    //@PreAuthorize("hasRole('USER')")  // USER만 가능한 요청
    //@PreAuthorize("#authoMemberDTO != null") // 사용자의 DTO가 있을때만 가능한 요청
    @GetMapping("/list")
    public String home(@AuthenticationPrincipal AuthMemberDTO authMemberDTO, Model model){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        pageRequestDTO.setWriterId(authMemberDTO.getId());

        PageResultDTO pageResultDTO = diaryService.getListPage(pageRequestDTO);

        model.addAttribute("result", pageResultDTO);

        log.info(authMemberDTO);

        return "list";
    }

}
