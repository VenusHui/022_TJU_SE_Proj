package com.fan.backend.pojo;

import com.fan.backend.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fander-usersystem")
public interface UserSystem {

    @GetMapping("/users/{userId}/")
    public Response getUser(@PathVariable Integer userId);
}
