package com.fan.dishsystem.service;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.utils.Response;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CommentService {
    public Response addComment(String dishId, Integer userId, String context, Double score, Date commentDate);
}
