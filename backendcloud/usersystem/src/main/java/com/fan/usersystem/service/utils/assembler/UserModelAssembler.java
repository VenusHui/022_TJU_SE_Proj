package com.fan.usersystem.service.utils.assembler;

import com.fan.usersystem.controller.UserController;
import com.fan.usersystem.pojo.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 21:55
 * @version: 1.0
 */
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel(),
                linkTo(methodOn(UserController.class).setUser(user.getUserId(), "userName", "")).withRel("set user name"),
                linkTo(methodOn(UserController.class).setUser(user.getUserId(), "avatar", "")).withRel("set user avatar"),
                linkTo(methodOn(UserController.class).setUser(user.getUserId(), "institute", "")).withRel("set user institute"),
                linkTo(methodOn(UserController.class).setUser(user.getUserId(), "grade", "")).withRel("set user grade"),
                linkTo(methodOn(UserController.class).deleteUser(user.getUserId())).withRel("delete"));
    }

    public CollectionModel<EntityModel<User>> toCollectionModel(List<User> userList) {
        List<EntityModel<User>> users = userList.stream()
                .map(this::toModel).toList();
        return CollectionModel.of(users);
    }
}
