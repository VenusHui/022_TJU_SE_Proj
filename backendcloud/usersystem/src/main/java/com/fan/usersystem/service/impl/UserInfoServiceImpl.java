package com.fan.usersystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fan.usersystem.mapper.UserMapper;
import com.fan.usersystem.pojo.User;
import com.fan.usersystem.service.UserInfoService;
import com.fan.usersystem.service.utils.assembler.UserModelAssembler;
import com.fan.usersystem.utils.Response;
import com.fan.usersystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 21:52
 * @version: 1.0
 */
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserMapper userMapper;

    private final UserModelAssembler assembler;

    public UserInfoServiceImpl(UserModelAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Response getUser(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        User user = userMapper.selectOne(queryWrapper);
        if (!userMapper.exists(queryWrapper)) {
            return new Response(ResponseCode.UNDEFINED_USER, "用户不存在", new HashMap<>());
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user", assembler.toModel(user));
        return new Response(ResponseCode.SUCCESS, "", data);
    }
}
