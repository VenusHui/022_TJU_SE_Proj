package com.fan.backend.service;

import com.fan.backend.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface DishSystemService {
    public Response getDishes(String filter, String value);
    public Response getDish(String dishId);
    public Response addDish(Map<String, Object> form, List<String> ingredientList);
    public Response setDish(String dishId, String filter, String value);
    public Response deleteDish(String dishId);
    public Response getAllComments();
    public Response getComment(String commentId);
    public Response setComment(String commentId, String filter, String value);
    public Response getCommentsByDishId(String dishId);
    public Response getCommentsByUserId(Integer userId);
    public Response addComment(String dishId, Map<String, Object> form);
    public Response deleteComment(String commentId);
}
