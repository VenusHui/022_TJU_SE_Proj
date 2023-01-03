package com.fan.dishsystem.service.impl;

import com.fan.dishsystem.pojo.Comment;
import com.fan.dishsystem.pojo.Dish;
import com.fan.dishsystem.repository.CommentRepository;
import com.fan.dishsystem.repository.DishRepository;
import com.fan.dishsystem.service.CommentService;
import com.fan.dishsystem.service.utils.assembler.CommentModelAssembler;
import com.fan.dishsystem.utils.Response;
import com.fan.dishsystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/2 19:36
 * @version: 1.0
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    DishRepository dishRepository;

    @Autowired
    CommentRepository commentRepository;

    private final CommentModelAssembler assembler;

    public CommentServiceImpl(CommentModelAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Response getAll() {
        List<Comment> comments = commentRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("comments", comments);
        return new Response(ResponseCode.SUCCESS, "", data);
    }

    @Override
    public Response getCommentById(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_COMMENT, "未知评论", null);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("comment", assembler.toModel(comment.get()));
        return new Response(ResponseCode.SUCCESS, "查询评论成功", data);
    }

    @Override
    public Response getCommentsByDishId(String dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        List<Comment> comments = dish.get().getComments();
        Map<String, Object> data = new HashMap<>();
        data.put("comments", assembler.toCollectionModel(comments));
        return new Response(ResponseCode.SUCCESS, "查询菜品评论成功", data);
    }

    @Override
    public Response getCommentsByUserId(Integer userId) {
        List<Dish> dishes = dishRepository.findByCommentsUserId(userId);
        List<Comment> userComments = new ArrayList<>();
        for (Dish dish : dishes) {
            System.out.println(dish);
            List<Comment> comments = dish.getComments();
            for (Comment comment : comments) {
                if (Objects.equals(comment.getUserId(), userId)) {
                    userComments.add(comment);
                }
            }
        }
        Map<String, Object> data = new HashMap<>();
        data.put("comments", userComments);
        return new Response(ResponseCode.SUCCESS, "查询用户评论成功", data);
    }

    @Override
    public Response addComment(String dishId, Integer userId, String context, Double score) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        dish.get().setScore((dish.get().getScore() * dish.get().getComments().size() + score) / (dish.get().getComments().size() + 1));
        Comment comment = new Comment(null, userId, context, score, new Date());
        commentRepository.insert(comment);
        dish.get().getComments().add(comment);
        dishRepository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("comment", assembler.toModel(comment));
        return new Response(ResponseCode.SUCCESS, "添加评论成功", data);
    }

    @Override
    public Response setCommentByContext(String commentId, String context) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_COMMENT, "未知评论", null);
        }
        comment.get().setContext(context);
        commentRepository.save(comment.get());
        Map<String, Object> data = new HashMap<>();
        data.put("comment", assembler.toModel(comment.get()));
        return new Response(ResponseCode.SUCCESS, "修改评论内容成功", data);
    }

    @Override
    public Response setCommentByScore(String commentId, Double score) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_COMMENT, "未知评论", null);
        }
        comment.get().setScore(score);
        commentRepository.save(comment.get());
        Map<String, Object> data = new HashMap<>();
        data.put("comment", assembler.toModel(comment.get()));
        return new Response(ResponseCode.SUCCESS, "修改评论评分成功", data);
    }

    @Override
    public Response deleteComment(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_COMMENT, "未知评论", null);
        }
        commentRepository.deleteById(commentId);
        return new Response(ResponseCode.SUCCESS, "删除评论成功", null);
    }
}
