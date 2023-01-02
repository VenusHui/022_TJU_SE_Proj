package com.fan.dishsystem.service.utils.assembler;

import com.fan.dishsystem.pojo.Comment;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/2 19:41
 * @version: 1.0
 */
public class CommentModelAssembler implements RepresentationModelAssembler<Comment, EntityModel<Comment>> {
    @Override
    public EntityModel<Comment> toModel(Comment comment) {
        return EntityModel.of(comment);
    }

    public CollectionModel<EntityModel<Comment>> toCollectionModel(List<Comment> commentList) {
        List<EntityModel<Comment>> comments = commentList.stream()
                .map(this::toModel).toList();
        return CollectionModel.of(comments);
    }
}
