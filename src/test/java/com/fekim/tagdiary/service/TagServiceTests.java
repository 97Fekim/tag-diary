package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.TagDTO;
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
        TagDTO dto = tagService.getMostPopularTag("emotion");

        System.out.println("-----------------------------tno = " + dto);

    }

}
