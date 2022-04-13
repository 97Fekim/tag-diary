package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository repository;

    @Test
    public void testInsertDummies(){

        Member member1 = Member.builder()
                .id("Romeo")
                .password("1234")
                .email("Roemo@gmail.com")
                .fromSocial(false)
                .build();

        Member member2 = Member.builder()
                .id("Juliet")
                .password("1234")
                .email("Juliet@gmail.com")
                .fromSocial(false)
                .build();

        repository.save(member1);
        repository.save(member2);

    }

}
