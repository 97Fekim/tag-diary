package com.fekim.tagdiary.member.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum MemberRole {
    USER, ADMIN
}
