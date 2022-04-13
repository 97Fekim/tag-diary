package com.fekim.tagdiary.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"writer"})
public class Diary extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

}
