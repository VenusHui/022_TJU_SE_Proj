package com.fan.backend.service;

import com.fan.backend.utils.Response;

public interface UserSystemService {
    public Response getAll();
    public Response getUser(Integer userId);
    public Response setUser(Integer userId, String filter, String param);
    public Response deleteUser(Integer userId);
}
