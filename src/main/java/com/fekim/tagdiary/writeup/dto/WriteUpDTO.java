package com.fekim.tagdiary.writeup.dto;

import com.fekim.tagdiary.tag.dto.TagDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriteUpDTO {

    private Long wno;
    private Long dno;
    private String content;
    private TagDTO tagDTO;

}
