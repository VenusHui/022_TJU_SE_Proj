package com.fan.usersystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author: VenusHui
 * @description: 实体类 User
 * @date: 2022/12/30 12:50
 * @version: 1.0
 */
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String password;
    private Integer studentId;
    private Timestamp registerDate;
    private String avatar;
    private String institute;
    private String grade;
}
