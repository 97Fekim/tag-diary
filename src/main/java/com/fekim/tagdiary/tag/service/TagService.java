package com.fekim.tagdiary.tag.service;

import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.tag.domain.Tag;

public interface TagService {

    TagDTO getMostPopularTag(String tagType);

    default TagDTO entityToDTO(Tag tag){

        TagDTO tagDTO = TagDTO.builder()
                .tno(tag.getTno())
                .name(tag.getTagName())
                .type(tag.getTagType())
                .build();

        return tagDTO;
    }

}
