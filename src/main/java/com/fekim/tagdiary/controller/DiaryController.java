package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.diary.dto.DiaryDTO;
import com.fekim.tagdiary.security.dto.AuthMemberDTO;
import com.fekim.tagdiary.diary.dto.PageRequestDTO;
import com.fekim.tagdiary.diary.dto.PageResultDTO;
import com.fekim.tagdiary.diary.service.DiaryService;
import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.tag.service.TagService;
import com.fekim.tagdiary.writeup.dto.WriteUpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@PreAuthorize("#authMemberDTO != null") // 사용자의 DTO가 있을때만 가능한 요청
public class DiaryController {

    private final DiaryService diaryService;

    private final TagService tagService;

    @GetMapping("/register")
    public void registerGet(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                            Model model){

        model.addAttribute("tagDTOList",tagService.getList());
    }

    /* 등록은 DiaryDTO를 파라미터로 보내야 합니다
    * 이는 json으로 처리하기 위해
    * REST Controller를 이용할 것이기 때문에 이 컨트롤러는 주석처리합니다.
    *  */
    /*@PostMapping("/register")
    public String registerPost(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                               DiaryDTO diaryDTO,
                               RedirectAttributes redirectAttributes){

        diaryDTO.setWriterId(authMemberDTO.getId());

        Long dno = diaryService.register(diaryDTO);

        redirectAttributes.addFlashAttribute("msg", dno);

        return "redirect:/diarys/list";

    }*/

    @GetMapping("/list")
    public void list(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                     @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                     Model model){

        pageRequestDTO.setWriterId(authMemberDTO.getId());

        PageResultDTO pageResultDTO = diaryService.getListPage(pageRequestDTO);

        model.addAttribute("result", pageResultDTO);

        log.info(authMemberDTO);
    }

    @GetMapping("/read")
    public String read(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                     @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                     Long dno,
                     Model model){

        log.info("dno : "+dno);
        
        DiaryDTO diaryDTO = diaryService.read(dno);

        if(!diaryDTO.getWriterId().equals(authMemberDTO.getId())) {
            return "redirect:/diarys/list";
        } else {
            model.addAttribute("diaryDTO", diaryDTO);
            return "/diarys/read";
        }

    }

    @GetMapping("/modify")
    public String modifyGet(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                       @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                       Long dno,
                       Model model){

        log.info("dno : "+dno);

        DiaryDTO diaryDTO = diaryService.read(dno);

        if(!diaryDTO.getWriterId().equals(authMemberDTO.getId())) {
            return "redirect:/diarys/list";
        } else {
            model.addAttribute("diaryDTO", diaryDTO);
            return "/diarys/modify";
        }
    }

    @PostMapping("/modify")
    public String modify(DiaryDTO diaryDTO,
                         @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes){

        diaryService.modify(diaryDTO);

        // 수정 후에 원래 있던 페이지로 가기 위해 request를 저장
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        redirectAttributes.addAttribute("type", pageRequestDTO.getType());
        redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
        redirectAttributes.addAttribute("dno", diaryDTO.getDno());

        return "redirect:/diarys/list";

    }

    @PostMapping("/remove")
    public String remove(@AuthenticationPrincipal AuthMemberDTO authMemberDTO,
                         Long dno,
                         RedirectAttributes redirectAttributes) {

        diaryService.removeDiaryWithWriteUps(dno);

        redirectAttributes.addFlashAttribute("msg", dno);

        return "redirect:/diarys/list";

    }

}
