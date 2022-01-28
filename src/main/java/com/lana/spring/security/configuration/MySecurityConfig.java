package com.lana.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@EnableWebSecurity
public class MySecurityConfig
        extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("lana")
                        .password("111")
                        .roles("Employee"))
                .withUser(userBuilder.username("max")
                        .password("222")
                        .roles("HR"))
                .withUser(userBuilder.username("ivan")
                        .password("333")
                        .roles("Manager", "HR"));


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Employee", "HR", "Manager")
                .antMatchers("/hr").hasRole("HR")
                .antMatchers("/manager/**").hasRole("Manager")
                .and().formLogin().permitAll();
    }


}
