package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.WriteUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteUpRepository extends JpaRepository<WriteUp, Long> {
}
