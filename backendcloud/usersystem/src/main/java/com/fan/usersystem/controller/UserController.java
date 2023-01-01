package com.fan.usersystem.controller;

import com.fan.usersystem.service.UserService;
import com.fan.usersystem.utils.Response;
import com.fan.usersystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 13:55
 * @version: 1.0
 */
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询所有用户
     * @date: 2023/1/1 17:42
     */
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/users/{userId}/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定用户信息
     * @date: 2023/1/1 13:58
     */
    public ResponseEntity<Response> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

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
    public ResponseEntity<Response> setUser(@PathVariable Integer userId,
                                            @RequestParam(value = "filter", defaultValue = "userName") String filter,
                                            @RequestParam(value = "param") String param) {
        if (Objects.equals(filter, "userName")) {
            return ResponseEntity.ok(userService.setUserName(userId, param));
        }
        else if (Objects.equals(filter, "avatar")) {
            return ResponseEntity.ok(userService.setUserAvatar(userId, param));
        }
        return ResponseEntity.badRequest().body(new Response(ResponseCode.REQUEST_PARAM_ERROR, "请求参数错误", null));
    }

    @DeleteMapping("/users/{userId}/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定用户
     * @date: 2023/1/1 17:36
     */
    public ResponseEntity<Response> deleteUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
