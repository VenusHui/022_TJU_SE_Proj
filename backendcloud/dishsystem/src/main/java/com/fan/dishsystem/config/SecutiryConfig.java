package com.fan.dishsystem.config;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
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
                        "/dishes/",
                        "/dishes/{dishId}/comments/",
                        "/comments/",
                        "/comments/{commentId}/",
                        "/users/{userId}/comments/").permitAll()
                .antMatchers(HttpMethod.POST,
                        "/dishes/",
                        "/dishes/{dishId}/comments/").permitAll()
                .antMatchers(HttpMethod.PUT,
                        "/comments/{commentId}/").permitAll()
                .antMatchers(HttpMethod.DELETE,
                        "/comments/{commentId}/").permitAll();
    }
}
