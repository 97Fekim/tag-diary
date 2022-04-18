package com.fekim.tagdiary.writeup.domain;

import com.fekim.tagdiary.BaseEntity;
import com.fekim.tagdiary.diary.domain.Diary;
import com.fekim.tagdiary.tag.domain.Tag;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"diary", "tag"})
public class WriteUp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;

    private String content;

}
