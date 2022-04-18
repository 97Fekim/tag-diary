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

    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean fromSocial;

    public AuthMemberDTO(String username,
                         String password,
                         boolean fromSocial,
                         Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);

        this.email = username;
        this.password = password;
        this.fromSocial = fromSocial;
        // id와 name은 Service에서 set
    }

}
