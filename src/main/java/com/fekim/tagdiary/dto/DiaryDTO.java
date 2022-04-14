package com.fekim.tagdiary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDTO {

    private Long dno;

    private String title;

    private String writer;

    @Builder.Default
    private List<WriteUpDTO> writeUpDTOList = new ArrayList<>();

}
