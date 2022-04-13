package com.fekim.tagdiary.service;

import com.fekim.tagdiary.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class WriteUpServiceTests {

    @Autowired
    private WriteUpService writeUpService;

    @Transactional
    @Test
    public void testGetMod(){
        Tag tag = writeUpService.getMod("emotion");

        System.out.println(tag.toString());
    }

}
