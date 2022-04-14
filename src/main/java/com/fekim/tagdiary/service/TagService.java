package com.fekim.tagdiary.service;

import com.fekim.tagdiary.dto.TagDTO;
import com.fekim.tagdiary.entity.Tag;

public interface TagService {

    public TagDTO getMostPopularTag(String tagType);

    default TagDTO entityToDTO(Tag tag){

        TagDTO tagDTO = TagDTO.builder()
                .tno(tag.getTno())
                .name(tag.getTagName())
                .type(tag.getTagType())
                .build();

        return tagDTO;
    }

}
