package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagRepositoryTests {

    @Autowired
    private TagRepository repository;

    @Test
    public void testInsertDummies(){

        repository.save(Tag.builder().tagName("기쁨").build());
        repository.save(Tag.builder().tagName("사랑").build());
        repository.save(Tag.builder().tagName("뿌듯").build());
        repository.save(Tag.builder().tagName("흐뭇").build());
        repository.save(Tag.builder().tagName("감격").build());
        repository.save(Tag.builder().tagName("감사").build());
        repository.save(Tag.builder().tagName("만족").build());
        repository.save(Tag.builder().tagName("황홀").build());
        repository.save(Tag.builder().tagName("신남").build());
        repository.save(Tag.builder().tagName("열정").build());
        repository.save(Tag.builder().tagName("설렘").build());
        repository.save(Tag.builder().tagName("기대").build());
        repository.save(Tag.builder().tagName("열망").build());
        repository.save(Tag.builder().tagName("상쾌").build());
        repository.save(Tag.builder().tagName("따분함").build());
        repository.save(Tag.builder().tagName("억울").build());
        repository.save(Tag.builder().tagName("초조").build());

        repository.save(Tag.builder().tagName("뭉클").build());
        repository.save(Tag.builder().tagName("허전").build());
        repository.save(Tag.builder().tagName("안타까움").build());
        repository.save(Tag.builder().tagName("벅참").build());
        repository.save(Tag.builder().tagName("홀가분").build());
        repository.save(Tag.builder().tagName("후련").build());
        repository.save(Tag.builder().tagName("쓸쓸").build());
        repository.save(Tag.builder().tagName("원망").build());

        repository.save(Tag.builder().tagName("허탈").build());
        repository.save(Tag.builder().tagName("짜증").build());
        repository.save(Tag.builder().tagName("막막").build());
        repository.save(Tag.builder().tagName("울적").build());
        repository.save(Tag.builder().tagName("후회").build());
        repository.save(Tag.builder().tagName("공허").build());
        repository.save(Tag.builder().tagName("허무").build());
        repository.save(Tag.builder().tagName("절망").build());
        repository.save(Tag.builder().tagName("불안").build());
        repository.save(Tag.builder().tagName("무기력").build());
        repository.save(Tag.builder().tagName("외로움").build());

    }

}
