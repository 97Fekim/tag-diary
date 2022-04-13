package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
