package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.DiaryDTO;
import com.fekim.tagdiary.dto.WriteUpDTO;
import com.fekim.tagdiary.entity.Diary;
import com.fekim.tagdiary.entity.WriteUp;
import com.fekim.tagdiary.repository.DiaryRepository;
import com.fekim.tagdiary.repository.TagRepository;
import com.fekim.tagdiary.repository.WriteUpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Log4j2
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{

    /* Diary를 저장하기 위해서는 모든 Repository를 주입받아야 함 */
    private final DiaryRepository diaryRepository;

    private final WriteUpRepository writeUpRepository;

    private final TagRepository tagRepository;

    @Override
    public Long register(DiaryDTO diaryDTO) {
        Map<String, Object> entityMap = dtoToEntity(diaryDTO);

        Diary diary = (Diary) entityMap.get("diary");   // Object -> Diary

        Diary saved = diaryRepository.save(diary);// Diary 먼저 저장

        /* Diary를 저장하면서 얻어온 dno를 diaryDTO의 dno에 저장 */
        for(WriteUpDTO writeUpDTO : diaryDTO.getWriteUpDTOList()){
            writeUpDTO.setDno(saved.getDno());
        }

        // 다시 dto->entity
        entityMap = dtoToEntity(diaryDTO);

        List<WriteUp> writeUpList = (List<WriteUp>) entityMap.get("writeUpList");   // Object -> List

        writeUpList.stream().forEach(writeUp -> {
            tagRepository.save(writeUp.getTag());   // Tag 먼저 저장
            writeUpRepository.save(writeUp);
        });

        return diary.getDno();
    }

    @Transactional
    @Override   // Diary 하나 삭제
    public void removeDiaryWithWriteUps(Long dno) {

        /* 쿼리 메서드로 작성 */
        // WriteUp들 부터 삭제
        writeUpRepository.deleteByDno(dno);
        // Diary 삭제
        diaryRepository.deleteById(dno);
    }


}
