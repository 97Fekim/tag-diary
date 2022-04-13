package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
