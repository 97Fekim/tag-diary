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

import java.util.HashMap;
import java.util.List;


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
        HashMap<String, Object> entityMap = new HashMap<>();

        Diary diary = (Diary) entityMap.get("diary");   // Object -> Diary

        List<WriteUp> writeUpList = (List<WriteUp>) entityMap.get("writeUpList");   // Object -> List

        diaryRepository.save(diary);    // Diary 먼저 저장

        writeUpList.stream().forEach(writeUp -> {
            tagRepository.save(writeUp.getTag());   // Tag 먼저 저장
            writeUpRepository.save(writeUp);
        });

        return diary.getDno();
    }
}
