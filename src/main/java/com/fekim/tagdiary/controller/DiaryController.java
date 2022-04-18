package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.diary.dto.DiaryDTO;
import com.fekim.tagdiary.security.dto.AuthMemberDTO;
import com.fekim.tagdiary.diary.dto.PageRequestDTO;
import com.fekim.tagdiary.diary.dto.PageResultDTO;
import com.fekim.tagdiary.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/diarys/")
public class DiaryController {

    private final DiaryService diaryService;

    //@PreAuthorize("#authoMemberDTO != null") // 사용자의 DTO가 있을때만 가능한 요청
    @GetMapping("/list")
    public void list(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                     @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                     Model model){

        pageRequestDTO.setWriterId(authMemberDTO.getId());

        PageResultDTO pageResultDTO = diaryService.getListPage(pageRequestDTO);

        model.addAttribute("result", pageResultDTO);

        log.info(authMemberDTO);
    }

    @GetMapping("/register")
    public void registerGet(){

    }

    @PostMapping("/regster")
    public String registerPost(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                             DiaryDTO diaryDTO,
                             RedirectAttributes redirectAttributes){

        diaryDTO.setWriterId(authMemberDTO.getId());
        Long dno = diaryService.register(diaryDTO);
        redirectAttributes.addAttribute("msg", dno);
        return "redirect:/diarys/list";

    }

    @GetMapping("/read")
    public void read(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                     @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                     Long dno,
                     Model model){

        log.info("dno : "+dno);

        DiaryDTO diaryDTO = diaryService.read(dno);

        model.addAttribute("diaryDTO", diaryDTO);

    }

}
