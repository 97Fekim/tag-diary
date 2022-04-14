package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.DiaryDTO;
import com.fekim.tagdiary.repository.DiaryRepository;
import com.fekim.tagdiary.repository.TagRepository;
import com.fekim.tagdiary.repository.WriteUpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{

    private final DiaryRepository diaryRepository;

    private final WriteUpRepository writeUpRepository;

    private final TagRepository tagRepository;

    @Override
    public Long register(DiaryDTO diaryDTO) {
        return null;
    }
}
