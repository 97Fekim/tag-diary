package com.fekim.tagdiary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    @Builder.Default
    private List<WriteUpDTO> writeUpDTOList = new ArrayList<>();

}
