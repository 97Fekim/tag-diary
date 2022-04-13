package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.WriteUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WriteUpRepository extends JpaRepository<WriteUp, Long> {

    @Query("select t.tno " +
            "from WriteUp w " +
            "left join w.tag t " +
            "where t.tagType = :tagType")
    List<Long> getTnoListByTagType(@Param("tagType") String tagType);

}
