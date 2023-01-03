package com.fan.preference.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 20:39
 * @version: 1.0
 */
public class SecutiryConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/preferences/",
                        "/users/{userId}/preference/",
                        "/users/{userId}/preference/liked/",
                        "/users/{userId}/preference/ate/",
                        "/users/{userId}/preference/allergens/").permitAll()
                .antMatchers(HttpMethod.POST,
                        "/users/{userId}/preference/",
                        "/users/{userId}/preference/liked/",
                        "/users/{userId}/preference/ate/",
                        "/users/{userId}/preference/allergens/").permitAll()
                .antMatchers(HttpMethod.DELETE,
                        "/users/{userId}/preference/liked/",
                        "/users/{userId}/preference/ate/",
                        "/users/{userId}/preference/allergens/").permitAll();
    }
}
