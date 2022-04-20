package com.fekim.tagdiary.tag.service;

import com.fekim.tagdiary.tag.dto.TagDTO;
import com.fekim.tagdiary.tag.domain.Tag;

import java.util.List;

public interface TagService {

    TagDTO getMostPopularTag(String tagType);

    List<TagDTO> getList();

    default TagDTO entityToDTO(Tag tag){

        TagDTO tagDTO = TagDTO.builder()
                .tno(tag.getTno())
                .name(tag.getTagName())
                .type(tag.getTagType())
                .color(tag.getTagColor())
                .build();

        return tagDTO;
    }

}
