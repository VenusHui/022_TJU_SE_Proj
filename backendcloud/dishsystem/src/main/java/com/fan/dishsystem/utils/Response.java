package com.fan.dishsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 13:19
 * @version: 1.0
 */
public class Response {
    private Integer code;
    private String message;
    private Map<String, Object> data;
}
