package com.fan.backend.controller.user;

import com.fan.backend.service.UserService;
import com.fan.backend.utils.Response;
import com.fan.backend.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/test/")
    public ResponseEntity<Object> test() {
        return ResponseEntity.ok("success");
    }

    @PostMapping("/users/token/")
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
        return ResponseEntity.badRequest().body(new Response(ResponseCode.ERROR, "请求参数错误", new HashMap<>()));
    }

    @PostMapping("/users/")
    public ResponseEntity<Response> register(@RequestParam Map<String, Object> form) {
        String userName = form.get("userName").toString();
        Integer studentId = parseInt(form.get("studentId").toString());
        String password = form.get("password").toString();
        return ResponseEntity.ok(userService.register(userName, studentId, password));
    }
}
