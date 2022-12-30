package com.fan.backend.controller.user;

import com.fan.backend.service.UserService;
import com.fan.backend.utils.Response;
import com.fan.backend.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 15:11
 * @version: 1.0
 */
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/token/")
    /**
     * @param form:
     *            userName/studentId:
     *            password
     * @param filter: 登录方式
     *              userName: 用户名密码登录
     *              studentId: 学号密码登录
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 用户登录
     * @date: 2022/12/30 18:18
     */
    public ResponseEntity<Response> login(@RequestParam Map<String, Object> form,
                                          @RequestParam(value = "filter", defaultValue = "studentId") String filter) {
        String password = form.get("password").toString();
        if (Objects.equals(filter, "studentId")) {
            Integer studentId = parseInt(form.get("studentId").toString());
            return ResponseEntity.ok(userService.loginByStudentId(studentId, password));
        }
        else if (Objects.equals(filter, "userName")) {
            String userName = form.get("userName").toString();
            return ResponseEntity.ok(userService.loginByUserName(userName, password));
        }
        return ResponseEntity.badRequest().body(new Response(ResponseCode.REQUEST_PARAM_ERROR, "请求参数错误", new HashMap<>()));
    }

    @PostMapping("/users/")
    /**
     * @param form:
     *            userName:
     *            studentId:
     *            password:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 用户注册
     * @date: 2022/12/30 18:19
     */
    public ResponseEntity<Response> register(@RequestParam Map<String, Object> form) {
        String userName = form.get("userName").toString();
        Integer studentId = parseInt(form.get("studentId").toString());
        String password = form.get("password").toString();
        return ResponseEntity.ok(userService.register(userName, studentId, password));
    }

    @PutMapping("/users/{userId}/password/")
    /**
     * @param userId: 
     * @param form:
     *            newPassword: 新密码
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 修改密码
     * @date: 2022/12/30 21:44
     */
    public ResponseEntity<Response> setPassword(@PathVariable Integer userId,
                                                @RequestParam Map<String, Object> form) {
        String newPassword = form.get("newPassword").toString();
        return ResponseEntity.ok(userService.setPassword(userId, newPassword));
    }
}
