package com.fan.dishsystem.service;

import com.fan.dishsystem.utils.Response;

public interface CommentService {
    public Response getAll();
    public Response getCommentById(String commentId);
    public Response getCommentsByDishId(String dishId);
    public Response getCommentsByUserId(Integer userId);
    public Response addComment(String dishId, Integer userId, String context, Double score);
    public Response setCommentByContext(String commentId, String context);
    public Response setCommentByScore(String commentId, Double score);
    public Response deleteComment(String commentId);
}
