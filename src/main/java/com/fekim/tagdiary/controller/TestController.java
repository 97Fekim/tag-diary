package com.fekim.tagdiary.controller;

import com.fekim.tagdiary.diary.dto.DiaryDTO;
import com.fekim.tagdiary.diary.dto.PageRequestDTO;
import com.fekim.tagdiary.diary.dto.PageResultDTO;
import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.diary.service.DiaryService;
import com.fekim.tagdiary.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController()
@RequiredArgsConstructor
public class TestController {

    private final TagService tagService;

    private final DiaryService diaryService;

    @GetMapping("/test")
    public TagDTO testApi(){

        return tagService.getMostPopularTag("emotion");

    }

    @PostMapping(value="")
    public ResponseEntity<Long> register(@RequestBody DiaryDTO diaryDTO){
        log.info("==============register==============");
        log.info(diaryDTO);

        Long num = diaryService.register(diaryDTO);

        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('USER')")  // USER만 접근할 수 있는 요청
    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO> getList(Long writerId){
        log.info("================getList===============");
        log.info(writerId);
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setWriterId(writerId);
        return new ResponseEntity<>(diaryService.getListPage(pageRequestDTO), HttpStatus.OK);
    }

    @GetMapping(value="/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiaryDTO> read(@PathVariable("num")Long num){

        log.info("===============read================");

        log.info(num);

        return new ResponseEntity<>(diaryService.read(num), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{num}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> remove(@PathVariable("num") Long num){
        log.info("================remove=================");
        log.info(num);

        diaryService.removeDiaryWithWriteUps(num);

        return new ResponseEntity<>("removed completely", HttpStatus.OK);
    }

    @PutMapping(value = "/{dno}", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> modify(@RequestBody DiaryDTO diaryDTO){
        log.info("================modify===============");
        log.info(diaryDTO);

        diaryService.modify(diaryDTO);

        return new ResponseEntity<>("modified", HttpStatus.OK);
    }


}
