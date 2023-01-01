package com.fan.backend.controller.user;

import com.fan.backend.service.UserSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 18:23
 * @version: 1.0
 */
public class UserSystemController {

    @Autowired
    UserSystemService userSystemService;

    @GetMapping("/users/")
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(userSystemService.getAll());
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
        return ResponseEntity.ok(userSystemService.getUser(userId));
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
    public Response setUser(@PathVariable Integer userId,
                            @RequestParam(value = "filter", defaultValue = "userName") String filter,
                            @RequestParam(value = "param") String param) {
        return userSystemService.setUser(userId, filter, param);
    }

    @DeleteMapping("/users/{userId}/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定用户
     * @date: 2023/1/1 17:36
     */
    public Response deleteUser(@PathVariable Integer userId) {
        return userSystemService.deleteUser(userId);
    }
}
