package com.fan.dishsystem.service.utils.assembler;

import com.fan.dishsystem.controller.DishController;
import com.fan.dishsystem.pojo.Dish;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 23:08
 * @version: 1.0
 */
public class DishModelAssembler implements RepresentationModelAssembler<Dish, EntityModel<Dish>> {
    @Override
    public EntityModel<Dish> toModel(Dish dish) {
        return EntityModel.of(dish,
                linkTo(methodOn(DishController.class).getAll()).withRel("all dishes"));
    }
}
