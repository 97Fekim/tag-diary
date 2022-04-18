package com.fekim.tagdiary.security;

import com.fekim.tagdiary.member.domain.Member;
import com.fekim.tagdiary.member.domain.MemberRole;
import com.fekim.tagdiary.member.domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addRole(){

        Member member1 = Member.builder()
                .name("Romeo")
                .password(passwordEncoder.encode("1234"))
                .email("Roemo@gmail.com")
                .fromSocial(false)
                .build();

        Member member2 = Member.builder()
                .name("Juliet")
                .password(passwordEncoder.encode("1234"))
                .email("Juliet@gmail.com")
                .fromSocial(false)
                .build();

        member1.addMemberRole(MemberRole.USER);
        member2.addMemberRole(MemberRole.USER);

        memberRepository.save(member1);
        memberRepository.save(member2);

    }

}
