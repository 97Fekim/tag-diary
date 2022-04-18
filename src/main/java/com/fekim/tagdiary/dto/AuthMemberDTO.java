package com.fekim.tagdiary.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Setter
@Getter
@ToString
public class AuthMemberDTO extends User {

    private String id;
    private String password;
    private String email;
    private boolean fromSocial;

    public AuthMemberDTO(String username,
                         String password,
                         String email,
                         boolean fromSocial,
                         Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);

        this.id = username;
        this.password = password;
        this.email = email;
        this.fromSocial = fromSocial;

    }



}
