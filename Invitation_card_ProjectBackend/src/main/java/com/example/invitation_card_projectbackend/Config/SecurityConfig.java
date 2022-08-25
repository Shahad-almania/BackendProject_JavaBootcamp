package com.example.invitation_card_projectbackend.Config;

import com.example.invitation_card_projectbackend.Service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configurable
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 private final DetailsService detailsService;

    @Override //check username and password from the database
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(detailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override //login and register
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/register").permitAll()
                .antMatchers("/api/v1/CardOrder/ordersPage").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/api/v1/CardOrder").hasAuthority("Customer")

//                .antMatchers(HttpMethod.POST,"/api/v1/card").hasAuthority("Customer") //**
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }



}
