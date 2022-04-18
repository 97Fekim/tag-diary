package com.fekim.tagdiary.repository;

import com.fekim.tagdiary.tag.domain.Tag;
import com.fekim.tagdiary.tag.domain.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagRepositoryTests {

    @Autowired
    private TagRepository repository;

    @Test
    public void testInsertDummies(){

        repository.save(Tag.builder().tagName("기쁨").tagType("emotion").build());
        repository.save(Tag.builder().tagName("사랑").tagType("emotion").build());
        repository.save(Tag.builder().tagName("뿌듯").tagType("emotion").build());
        repository.save(Tag.builder().tagName("흐뭇").tagType("emotion").build());
        repository.save(Tag.builder().tagName("감격").tagType("emotion").build());
        repository.save(Tag.builder().tagName("감사").tagType("emotion").build());
        repository.save(Tag.builder().tagName("만족").tagType("emotion").build());
        repository.save(Tag.builder().tagName("황홀").tagType("emotion").build());
        repository.save(Tag.builder().tagName("신남").tagType("emotion").build());
        repository.save(Tag.builder().tagName("열정").tagType("emotion").build());
        repository.save(Tag.builder().tagName("설렘").tagType("emotion").build());
        repository.save(Tag.builder().tagName("기대").tagType("emotion").build());
        repository.save(Tag.builder().tagName("열망").tagType("emotion").build());
        repository.save(Tag.builder().tagName("상쾌").tagType("emotion").build());
        repository.save(Tag.builder().tagName("따분함").tagType("emotion").build());
        repository.save(Tag.builder().tagName("억울").tagType("emotion").build());
        repository.save(Tag.builder().tagName("초조").tagType("emotion").build());

        repository.save(Tag.builder().tagName("뭉클").tagType("emotion").build());
        repository.save(Tag.builder().tagName("허전").tagType("emotion").build());
        repository.save(Tag.builder().tagName("안타까움").tagType("emotion").build());
        repository.save(Tag.builder().tagName("벅참").tagType("emotion").build());
        repository.save(Tag.builder().tagName("홀가분").tagType("emotion").build());
        repository.save(Tag.builder().tagName("후련").tagType("emotion").build());
        repository.save(Tag.builder().tagName("쓸쓸").tagType("emotion").build());
        repository.save(Tag.builder().tagName("원망").tagType("emotion").build());

        repository.save(Tag.builder().tagName("허탈").tagType("emotion").build());
        repository.save(Tag.builder().tagName("짜증").tagType("emotion").build());
        repository.save(Tag.builder().tagName("막막").tagType("emotion").build());
        repository.save(Tag.builder().tagName("울적").tagType("emotion").build());
        repository.save(Tag.builder().tagName("후회").tagType("emotion").build());
        repository.save(Tag.builder().tagName("공허").tagType("emotion").build());
        repository.save(Tag.builder().tagName("허무").tagType("emotion").build());
        repository.save(Tag.builder().tagName("절망").tagType("emotion").build());
        repository.save(Tag.builder().tagName("불안").tagType("emotion").build());
        repository.save(Tag.builder().tagName("무기력").tagType("emotion").build());
        repository.save(Tag.builder().tagName("외로움").tagType("emotion").build());

    }


}
