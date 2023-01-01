package com.fan.backend.controller.user;

import com.fan.backend.service.UserSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/users/{userId}/")
    public ResponseEntity<Response> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userSystemService.getUser(userId));
    }
}
