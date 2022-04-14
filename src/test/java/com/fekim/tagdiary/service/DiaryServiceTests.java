package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.DiaryDTO;
import com.fekim.tagdiary.dto.TagDTO;
import com.fekim.tagdiary.dto.WriteUpDTO;
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


}
