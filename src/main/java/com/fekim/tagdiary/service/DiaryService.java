package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.DiaryDTO;
import com.fekim.tagdiary.dto.WriteUpDTO;
import com.fekim.tagdiary.entity.Diary;
import com.fekim.tagdiary.entity.Member;
import com.fekim.tagdiary.entity.Tag;
import com.fekim.tagdiary.entity.WriteUp;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DiaryService {

    /* 일기 등록 */
    Long register(DiaryDTO diaryDTO);
    /* 일기 삭제 */
    void removeDiaryWithWriteUps(Long dno);
    /* 일기 리스트 */

    /* DiaryDTO -> Diary
     * DiaryDTO가 WriteUp을 List로 참조하고 있기때문에
     * 반환타입을 Map<String, Object>으로 지정 */
    default Map<String, Object> dtoToEntity(DiaryDTO diaryDTO){

        Map<String, Object> entityMap = new HashMap<>();

        /* Diary 처리 (엔티티 Diary생성) */
        Diary diary = Diary.builder()
                .title(diaryDTO.getTitle())
                .writer(Member.builder()
                        .id(diaryDTO
                        .getWriter())
                        .build())
                .build();

        entityMap.put("diary", diary);

        /* List<WriteUp> 처리 */
        List<WriteUpDTO> writeUpDTOList = diaryDTO.getWriteUpDTOList();

        if(writeUpDTOList != null && writeUpDTOList.size() > 0){    // List가 존재하면(일기에 태그와 내용이 있으면)

            /* 엔티티 WriteUp 리스트 생성 */
            List<WriteUp> writeUpList = writeUpDTOList.stream().map(writeUpDTO -> {

                WriteUp writeUp = WriteUp.builder()
                        .content(writeUpDTO.getContent())
                        .diary(Diary.builder().dno(writeUpDTO.getDno()).build())
                        .tag(Tag.builder()
                                .tno(writeUpDTO.getTagDTO().getTno())
                                .tagName(writeUpDTO.getTagDTO().getName())
                                .tagType(writeUpDTO.getTagDTO().getType())
                                .build())
                        .build();

                return writeUp;

            }).collect(Collectors.toList());

            entityMap.put("writeUpList", writeUpList);
        }

        return entityMap;
    }

}
