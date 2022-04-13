package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
