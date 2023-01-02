package com.fan.dishsystem.repository;

import com.fan.dishsystem.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/2 21:49
 * @version: 1.0
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
