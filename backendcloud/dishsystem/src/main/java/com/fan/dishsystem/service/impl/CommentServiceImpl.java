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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author climo
 * @version 1.0
 * @date 2023/1/2 10:17
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    DishRepository dishRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Response addComment(String dishId, Integer userId, String context, Double score, Date commentDate) {
        if (!dishRepository.existsById(dishId)) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }

        Comment comment = new Comment(userId,context,score,commentDate);
        Dish dish = dishRepository.findDishBy_id(dishId);
        List<Comment> comments = dish.getComments();
        comments.add(comment);

        Query query = Query.query(Criteria.where("_id").is(dishId));
        Update update = new Update();
        mongoTemplate.updateFirst(query,update,Dish.class);

        return new Response(ResponseCode.SUCCESS, "添加评论成功", null);;
    }
}
