package com.fekim.tagdiary.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDTO {

    private Long tno;
    private String name;
    private String type;

}
