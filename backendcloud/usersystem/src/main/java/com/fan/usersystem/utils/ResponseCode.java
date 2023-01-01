package com.fan.usersystem.utils;

/**
 * @author: VenusHui
 * @description: 返回代码表
 * @date: 2022/12/30 15:35
 * @version: 1.0
 */
public class ResponseCode {
    public final static Integer SUCCESS = 200;              // 请求成功
    public final static Integer LOGIN_ERROR = 201;          // 登录失败
    public final static Integer REGISTER_ERROR = 202;       // 注册失败
    public final static Integer SET_PASSWORD_ERROR = 203;   // 修改密码失败
    public final static Integer UNDEFINED_USER = 211;       // 未知用户
    public final static Integer UNKNOWN_ERROR = 500;        // 未知错误
    public final static Integer REQUEST_PARAM_ERROR = 501;  // 请求参数错误
}
