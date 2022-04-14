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
            "where w.id = :writer " +
            "group by d")
    Page<Diary> getList(Pageable pageable, @Param("writer") String writer);

}
