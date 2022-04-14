package com.fekim.tagdiary.dto;

import com.fekim.tagdiary.entity.Diary;
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

    private Long wno;
    private Long dno;
    private String content;
    private TagDTO tagDTO;

}
