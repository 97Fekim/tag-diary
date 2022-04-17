package com.fekim.tagdiary.repository.search;

import com.fekim.tagdiary.entity.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchDiaryRepository {

    Page<Diary> searchPage(String type, String keyword, String writer, Pageable pageable);

}
