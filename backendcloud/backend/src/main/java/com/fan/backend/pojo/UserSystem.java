package com.fan.backend.pojo;

import com.fan.backend.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("fander-usersystem")
public interface UserSystem {

    @GetMapping("/users/")
    public Response getAll();

    @GetMapping("/users/{userId}/")
    public Response getUser(@PathVariable Integer userId);

    @PutMapping("/users/{userId}/")
    /**
     * @param userId:
     * @param filter:
     *              userName: 修改用户名
     *              avatar: 修改用户头像
     * @param param: 新用户名称 / 新头像链接
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 修改用户信息
     * @date: 2023/1/1 17:31
     */
    public Response setUser(@PathVariable Integer userId,
                            @RequestParam(value = "filter", defaultValue = "userName") String filter,
                            @RequestParam(value = "param") String param);

    @DeleteMapping("/users/{userId}/")
    public Response deleteUser(@PathVariable Integer userId);
}
