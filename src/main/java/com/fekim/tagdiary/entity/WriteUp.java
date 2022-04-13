package com.fekim.tagdiary.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"diary", "tag"})
public class WriteUp extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;

    private String content;

}
