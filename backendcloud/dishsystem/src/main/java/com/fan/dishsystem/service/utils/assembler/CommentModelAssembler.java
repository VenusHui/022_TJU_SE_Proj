package com.fan.dishsystem.service.utils.assembler;

import com.fan.dishsystem.controller.CommentController;
import com.fan.dishsystem.controller.DishController;
import com.fan.dishsystem.pojo.Comment;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author climo
 * @version 1.0
 * @date 2023/1/2 11:40
 */
public class CommentModelAssembler implements RepresentationModelAssembler<Comment, EntityModel<Comment>> {
    @Override
    public EntityModel<Comment> toModel(Comment comment) {
        return null;
    }
}
