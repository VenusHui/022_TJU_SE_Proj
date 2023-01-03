package com.fan.backend.service.impl;

import com.fan.backend.pojo.DishSystem;
import com.fan.backend.service.DishSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 0:11
 * @version: 1.0
 */
public class DishSystemServiceImpl implements DishSystemService {

    @Autowired
    DishSystem dishSystem;

    @Override
    public Response getDishes(String filter, String value) {
        return dishSystem.getDishes(filter, value);
    }

    @Override
    public Response getDish(String dishId) {
        return dishSystem.getDish(dishId);
    }

    @Override
    public Response addDish(Map<String, Object> form) {
        return dishSystem.addDish(form);
    }

    @Override
    public Response setDish(String dishId, String filter, String value) {
        return dishSystem.setDish(dishId, filter, value);
    }

    @Override
    public Response deleteDish(String dishId) {
        return dishSystem.deleteDish(dishId);
    }

    @Override
    public Response getAllComments() {
        return dishSystem.getAllComments();
    }

    @Override
    public Response getComment(String commentId) {
        return dishSystem.getComment(commentId);
    }

    @Override
    public Response setComment(String commentId, String filter, String value) {
        return dishSystem.setComment(commentId, filter, value);
    }

    @Override
    public Response getCommentsByDishId(String dishId) {
        return dishSystem.getCommentsByDishId(dishId);
    }

    @Override
    public Response getCommentsByUserId(Integer userId) {
        return dishSystem.getCommentsByUserId(userId);
    }

    @Override
    public Response addComment(String dishId, Map<String, Object> form) {
        return dishSystem.addComment(dishId, form);
    }

    @Override
    public Response deleteComment(String commentId) {
        return dishSystem.deleteComment(commentId);
    }
}
