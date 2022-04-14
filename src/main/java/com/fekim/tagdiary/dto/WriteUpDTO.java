package com.fekim.tagdiary.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WriteUpDTO {

    /* WriteUp */
    private Long wno;
    private String title;
    /* Tag */
    private Long tno;
    private String tagName;
    private String tagType;

    private List<WriteUpDTO> writeUpDTOList;

}
