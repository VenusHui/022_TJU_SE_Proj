package com.fan.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fan.backend.mapper.UserMapper;
import com.fan.backend.pojo.User;
import com.fan.backend.service.UserService;
import com.fan.backend.service.utils.assembler.UserModelAssembler;
import com.fan.backend.service.utils.UserDetailsImpl;
import com.fan.backend.utils.GlobalIData;
import com.fan.backend.utils.JwtUtil;
import com.fan.backend.utils.Response;
import com.fan.backend.utils.ResponseCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 13:17
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserModelAssembler assembler;

    public UserServiceImpl(UserModelAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Response loginByUserName(String userName, String password) {
        Map<String, Object> data = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        User user = userMapper.selectOne(queryWrapper);
        return getResponse(password, data, user);
    }

    @Override
    public Response loginByStudentId(Integer studentId, String password) {
        Map<String, Object> data = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);
        User user = userMapper.selectOne(queryWrapper);
        return getResponse(password, data, user);
    }

    @Override
    public Response register(String userName, Integer studentId, String password) {
        QueryWrapper<User> queryWrapperName = new QueryWrapper<>();
        QueryWrapper<User> queryWrapperId = new QueryWrapper<>();
        queryWrapperName.eq("user_name", userName);
        queryWrapperId.eq("student_id", studentId);
        if (!userMapper.exists(queryWrapperName) && !userMapper.exists(queryWrapperId)) {
            Map<String, Object> data = new HashMap<>();
            String encodedPassword = passwordEncoder.encode(password);
            Timestamp timestamp = new Timestamp(new Date().getTime());
            User user = new User(null, userName, encodedPassword, studentId, timestamp, GlobalIData.AVATAR_URL);
            userMapper.insert(user);
            data.put("user", assembler.toModel(user));
            return new Response(ResponseCode.SUCCESS, "注册成功", data);
        }
        return new Response(ResponseCode.REGISTER_ERROR, "注册失败，用户名或学号已存在", null);
    }

    @Override
    public Response setPassword(Integer userId, String newPassword) {
        User user = userMapper.selectById(userId);
        if (passwordEncoder.matches(newPassword, user.getPassword())) {
            return new Response(ResponseCode.SET_PASSWORD_ERROR, "密码与原密码相同", null);
        }
        String encodedPassword = passwordEncoder.encode(newPassword);
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("password", encodedPassword).eq("user_id", userId);
        userMapper.update(user, userUpdateWrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("user", assembler.toModel(user));
        return new Response(ResponseCode.SUCCESS, "修改密码成功", data);
    }

    @NotNull
    private Response getResponse(String password, Map<String, Object> data, User user) {
        if (user == null) {
            return new Response(ResponseCode.LOGIN_ERROR, "用户不存在", data);
        }
        data.put("userId", user.getUserId());
        data.put("token", getToken(user.getUserName(), password));
        return new Response(ResponseCode.SUCCESS, "登录成功", data);
    }

    public String getToken(String userName, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        return JwtUtil.createJWT(user.getUserId().toString());
    }
}
