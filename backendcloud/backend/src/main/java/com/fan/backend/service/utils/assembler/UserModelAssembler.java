package com.fan.backend.service.utils.assembler;

import com.fan.backend.controller.user.UserController;
import com.fan.backend.pojo.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2022/12/30 16:03
 * @version: 1.0
 */
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>>  {
    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).login(new HashMap<>(), "studentId")).withRel("studentId login"),
                linkTo(methodOn(UserController.class).login(new HashMap<>(), "userName")).withRel("userName login"));
    }

    public CollectionModel<EntityModel<User>> toCollectionModel(List<User> userList) {
        List<EntityModel<User>> users = userList.stream()
                .map(this::toModel).toList();
        return CollectionModel.of(users);
    }
}
