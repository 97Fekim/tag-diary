package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Diary;
import com.fekim.tagdiary.entity.Tag;
import com.fekim.tagdiary.entity.WriteUp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class WriteUpRepositoryTests {

    @Autowired
    private WriteUpRepository repository;

    @Test
    public void testInsertDummies(){

        IntStream.rangeClosed(1,800).forEach(i -> {

            // 일기장 번호
            Long dno = (long) (Math.random() * 400) + 1;

            Long tno = (long)(Math.random() * 36) + 1;

            Diary diary = Diary.builder().dno(dno).build();

            WriteUp writeUp = WriteUp.builder()
                    .diary(diary)
                    .tag(Tag.builder().tno(tno).build())
                    .content("이 태그에 대한 " + i + "번째 내용이에요")
                    .build();

            repository.save(writeUp);

        });
    }

    //@Transactional
    @Test
    public void testGetTnoListByTagType(){

        List<Long> result = repository.getTnoListByTagType("emotion");

        System.out.println(result.toString());

    }

}
