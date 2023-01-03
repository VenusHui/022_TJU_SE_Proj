package com.fan.dishsystem.repository;

import com.fan.dishsystem.pojo.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DishRepository extends MongoRepository<Dish, String> {
    public Boolean existsByDishName(String dishName);
    public Boolean existsByPosition(String position);
    @Query("{'comments': {$elemMatch: {'user_id': ?0}}}")
    public List<Dish> findByCommentsUserId(Integer userId);
    public List<Dish> findByDishName(String dishName);
    public List<Dish> findByPosition(String position);
}
