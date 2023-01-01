package com.fan.usersystem.service;

import com.fan.usersystem.utils.Response;

public interface UserService {
    public Response getAll();
    public Response getUser(Integer userId);
    public Response setUserName(Integer userId, String newUserName);
    public Response setUserAvatar(Integer userId, String avatar);
    public Response deleteUser(Integer userId);
}
