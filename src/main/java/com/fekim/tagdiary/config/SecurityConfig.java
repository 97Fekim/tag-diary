package com.fekim.tagdiary.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/test").hasRole("USER")
                .antMatchers("/list").hasRole("USER");

        http.formLogin();   // 인가/인증에 문제시 로그인 화면, .loginPage()나 .loginProcessUrl() 을 이용해서 커스텀 로그인 페이지 적용 가능
        http.csrf().disable();
        http.logout();      // .logoutPage()나 .logoutProcessUrl()을 이용해서 커스텀 로그아웃 페이지 적용 가능

    }

//    @Override 더이상 사용하지 않는다.
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.inMemoryAuthentication().withUser("Romeo")
//        // 1234 인코딩 결과
//                .password("$2a$10$aBNxCUUFZNl3qYcEDUl9muJyLW3IL7Pxq0eSDT7rK2YxdUc8swm2O")
//                .roles("USER");
//
//    }

}
