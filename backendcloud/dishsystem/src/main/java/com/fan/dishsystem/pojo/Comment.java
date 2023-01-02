package com.fan.dishsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 22:56
 * @version: 1.0
 */
public class Comment {
    private Integer userId;
    private String context;
    private Double score;
    private Date commentDate;
}
