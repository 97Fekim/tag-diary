package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Diary;
import com.fekim.tagdiary.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class DiaryRepositoryTests {

    @Autowired
    private DiaryRepository repository;

    @Test
    public void testInsertDummiesFail() {
        Diary diary1 = Diary.builder()
                .writer(Member.builder().id("Michael").build())
                .title("1월 1일")
                .build();

        repository.save(diary1);
    }

    @Test
    public void testInsertDummies(){

        IntStream.rangeClosed(1,200).forEach(i -> {
            int month = 1 + i / 30;
            int day = 1 + i % 30;

            Diary diary1 = Diary.builder()
                    .writer(Member.builder().id("Romeo").build())
                    .title(month + "월 " + day + "일")
                    .build();

            repository.save(diary1);
        });

        IntStream.rangeClosed(1,200).forEach(i -> {
            int month = 1 + i / 30;
            int day = 1 + i % 30;

            Diary diary1 = Diary.builder()
                    .writer(Member.builder().id("Juliet").build())
                    .title(month + "월 " + day + "일")
                    .build();

            repository.save(diary1);
        });

    }

    @Transactional
    @Test
    public void testGetList(){

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "dno"));

        Page<Object> result = repository.getList(pageRequest,"Romeo");

        for(Object arr : result){
            System.out.println(arr.toString());
        }
    }

    @Transactional
    @Test
    public void testGetDiaryWithWritesUpAndTags(){
        List<Object[]> result = repository.getDiaryWithWritesUpAndTags(195L);

        for(Object[] objects : result){
            System.out.println(Arrays.toString(objects));
        }
    }

}
