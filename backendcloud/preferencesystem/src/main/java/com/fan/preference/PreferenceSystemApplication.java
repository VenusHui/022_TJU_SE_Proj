package com.fan.preference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PreferenceSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(PreferenceSystemApplication.class, args);
    }
}