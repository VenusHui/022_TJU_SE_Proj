package com.fan.dishsystem.repository;

import com.fan.dishsystem.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
