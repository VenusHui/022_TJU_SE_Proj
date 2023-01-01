package com.fan.backend.service.impl;

import com.fan.backend.pojo.UserSystem;
import com.fan.backend.service.UserSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 16:12
 * @version: 1.0
 */
public class UserSystemServiceImpl implements UserSystemService {
    @Autowired
    UserSystem userSystem;

    @Override
    public Response getUser(Integer userId) {
        return userSystem.getUser(userId);
    }
}
