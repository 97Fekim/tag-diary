package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    
    // 특정 회원의 모든 Diary 조회
    @Query("select d " +
            "from Diary d " +
            "left join d.writer w " +
            "where w.id = :writer")
    List<Object> getList(@Param("writer") String writer);

    // dno로 특정 Diary 및 WriteUp까지 모두 조회
    
}
