package com.fekim.tagdiary.service;

import com.fekim.tagdiary.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class TagServiceTests {

    @Autowired
    private TagService tagService;

    @Transactional
    @Test
    public void testGetMod(){
        Tag tag = tagService.getMod("emotion");

        System.out.println(tag.toString());
    }

}
