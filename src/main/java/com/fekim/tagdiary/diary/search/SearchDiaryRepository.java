package com.fekim.tagdiary.diary.search;

import com.fekim.tagdiary.diary.domain.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchDiaryRepository {

    Page<Diary> searchPage(String type, String keyword, Long writerId, Pageable pageable);

}
