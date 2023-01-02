package com.fan.dishsystem.service.impl;

import com.fan.dishsystem.repository.CommentRepository;
import com.fan.dishsystem.service.CommentService;
import com.fan.dishsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author climo
 * @version 1.0
 * @date 2023/1/2 10:17
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository repository;


    @Override
    public Response addComment(Integer userId, String context, Double score, Date commentDate) {
        return null;
    }
}
