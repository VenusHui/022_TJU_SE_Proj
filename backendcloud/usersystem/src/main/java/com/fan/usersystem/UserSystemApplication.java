package com.fan.usersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSystemApplication.class, args);
    }
}