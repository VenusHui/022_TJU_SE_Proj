package com.fan.backend.service;

import com.fan.backend.utils.Response;

public interface UserService {
    public Response loginByUserName(String userName, String password);
    public Response loginByStudentId(Integer studentId, String password);
    public Response register(String userName, Integer studentId, String password);
}
