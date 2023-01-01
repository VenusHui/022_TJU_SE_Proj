package com.fan.dishsystem.service.impl;

import com.fan.dishsystem.pojo.Dish;
import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.pojo.Preference;
import com.fan.dishsystem.repository.DishRepository;
import com.fan.dishsystem.service.DishService;
import com.fan.dishsystem.utils.Response;
import com.fan.dishsystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 21:34
 * @version: 1.0
 */
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository repository;

    @Override
    public Response getAll() {
        List<Dish> dishes = repository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("dishes", dishes);
        return new Response(ResponseCode.SUCCESS, "", data);
    }

    @Override
    public Response getDish(String dishId) {
        return null;
    }

    @Override
    public Response setDish(String dishId) {
        return null;
    }

    @Override
    public Response addDish(String dishName, String description, String photoUrl, String position, Map<String, Integer> preferenceMap, List<Ingredient> ingredients) {
        if (repository.existsByDishName(dishName)) {
            return new Response(ResponseCode.ADD_DISH_ERROR, "该菜品已存在", null);
        }
        Preference preference = new Preference(
                preferenceMap.get("spiciness"),
                preferenceMap.get("sourness"),
                preferenceMap.get("sweetness"),
                preferenceMap.get("bitterness"));
        Dish dish = new Dish(null, dishName, description, photoUrl, position, null, preference, ingredients);
        repository.insert(dish);
        Map<String, Object> data = new HashMap<>();
        data.put("dish", dish);
        return new Response(ResponseCode.SUCCESS, "添加菜品成功", data);
    }

    @Override
    public Response deleteDish(String dishId) {
        if (!repository.existsById(dishId)) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        repository.deleteById(dishId);
        return new Response(ResponseCode.SUCCESS, "删除菜品成功", null);
    }


}
