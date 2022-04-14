package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DiaryServiceTests {

    @Autowired
    private DiaryService diaryService;

    @Test
    public void testRegister(){

        List<WriteUpDTO> writeUpDTOList = new ArrayList<>();

        writeUpDTOList.add(WriteUpDTO.builder()
                        .content("등록 테스트 내용5")
                        .tagDTO(TagDTO.builder().tno(5L).name("감격").build())
                .build());

        writeUpDTOList.add(WriteUpDTO.builder()
                .content("등록 테스트 내용6")
                .tagDTO(TagDTO.builder().tno(6L).name("감사").type("emotion").build())
                .build());

        DiaryDTO diaryDTO = DiaryDTO.builder()
                .title("등록 테스트 제목3")
                .writer("Romeo")
                .writeUpDTOList(writeUpDTOList)
                .build();

        diaryService.register(diaryDTO);
        
    }

    @Test
    public void testRemoveDiary(){
        diaryService.removeDiaryWithWriteUps(403L);
    }

    @Test
    public void testRead(){
        DiaryDTO dto = diaryService.read(195L);
        System.out.println(dto.getDno());
        System.out.println(dto.getTitle());
        System.out.println(dto.getWriter());
        System.out.println(dto.getModDate());
        System.out.println(dto.getRegDate());

        for(WriteUpDTO writeUpDTO : dto.getWriteUpDTOList()){
            System.out.println(writeUpDTO);
        }

    }

    @Test
    public void testGetList(){
        PageResultDTO pageResultDTO = diaryService.getListPage(new PageRequestDTO(), "Romeo");

        for(DiaryDTO diaryDTO : pageResultDTO.getDtoList()){
            System.out.println(diaryDTO);
        }
        System.out.println(pageResultDTO);

    }

}