package com.fekim.tagdiary.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity{

    @Id
    private String id;

    private String password;

    private String email;

    private boolean fromSocial;

}
