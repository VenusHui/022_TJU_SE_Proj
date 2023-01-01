package com.fan.usersystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fan.usersystem.mapper.UserMapper;
import com.fan.usersystem.pojo.User;
import com.fan.usersystem.service.UserService;
import com.fan.usersystem.service.utils.assembler.UserModelAssembler;
import com.fan.usersystem.utils.Response;
import com.fan.usersystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 21:52
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    private final UserModelAssembler assembler;

    public UserServiceImpl(UserModelAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Response getAll() {
        List<User> users = userMapper.selectList(null);
        Map<String, Object> data = new HashMap<>();
        data.put("users", assembler.toCollectionModel(users));
        return new Response(ResponseCode.SUCCESS, "", data);
    }

    @Override
    public Response getUser(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        User user = userMapper.selectOne(queryWrapper);
        if (!userMapper.exists(queryWrapper)) {
            return new Response(ResponseCode.UNDEFINED_USER, "用户不存在", null);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user", assembler.toModel(user));
        return new Response(ResponseCode.SUCCESS, "", data);
    }

    @Override
    public Response setUserName(Integer userId, String newUserName) {
        User user = userMapper.selectById(userId);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", newUserName);
        if (userMapper.exists(queryWrapper)) {
            return new Response(ResponseCode.MODIFY_USER_ERROR, "用户名已存在", null);
        }
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("user_name", newUserName).eq("user_id", userId);
        userMapper.update(user, updateWrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("user", assembler.toModel(user));
        return new Response(ResponseCode.SUCCESS, "修改用户名成功", data);
    }

    @Override
    public Response setUserAvatar(Integer userId, String avatar) {
        User user = userMapper.selectById(userId);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("avatar", avatar).eq("user_id", userId);
        userMapper.update(user, updateWrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("user", assembler.toModel(user));
        return new Response(ResponseCode.SUCCESS, "修改头像成功", data);
    }

    @Override
    public Response deleteUser(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        User user = userMapper.selectOne(queryWrapper);
        if (!userMapper.exists(queryWrapper)) {
            return new Response(ResponseCode.UNDEFINED_USER, "用户不存在", null);
        }
        userMapper.deleteById(userId);
        return new Response(ResponseCode.SUCCESS, "删除用户成功", null);
    }
}
