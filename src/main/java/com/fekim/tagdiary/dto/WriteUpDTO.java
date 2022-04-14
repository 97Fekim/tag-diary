package com.fekim.tagdiary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriteUpDTO {

    /* WriteUp */
    private Long wno;
    private String content;

    private TagDTO tagDTO;

}
