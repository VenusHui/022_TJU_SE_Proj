package com.fan.usersystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.usersystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
