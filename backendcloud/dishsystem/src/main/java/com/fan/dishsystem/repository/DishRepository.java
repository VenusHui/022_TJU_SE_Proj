package com.fan.dishsystem.repository;

import com.fan.dishsystem.pojo.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DishRepository extends MongoRepository<Dish, String> {
    public Boolean existsByDishName(String dishName);
    public Boolean existsDishByPosition(String position);
    public Dish findDishByDishName(String dishName);

    public Dish findDishBy_id(String dishId);
}
