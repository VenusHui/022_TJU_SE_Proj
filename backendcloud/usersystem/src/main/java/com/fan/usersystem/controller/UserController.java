package com.fan.usersystem.controller;

import com.fan.usersystem.service.UserInfoService;
import com.fan.usersystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 13:55
 * @version: 1.0
 */
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/users/{userId}/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定用户信息
     * @date: 2023/1/1 13:58
     */
    public ResponseEntity<Response> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userInfoService.getUser(userId));
    }
}
