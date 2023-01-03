package com.fan.dishsystem.service.impl;

import com.fan.dishsystem.pojo.Dish;
import com.fan.dishsystem.pojo.Preference;
import com.fan.dishsystem.repository.DishRepository;
import com.fan.dishsystem.service.DishService;
import com.fan.dishsystem.service.utils.assembler.DishModelAssembler;
import com.fan.dishsystem.utils.Response;
import com.fan.dishsystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Integer.parseInt;

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

    private final DishModelAssembler assembler;

    public DishServiceImpl(DishModelAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Response getAll() {
        List<Dish> dishes = repository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("dishes", dishes);
        return new Response(ResponseCode.SUCCESS, "", data);
    }

    @Override
    public Response getDishById(String dishId) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "查询菜品成功", data);
    }

    @Override
    public Response getDishesByName(String dishName) {
        List<Dish> dishes = repository.findByDishName(dishName);
        Map<String, Object> data = new HashMap<>();
        data.put("dishes", assembler.toCollectionModel(dishes));
        return new Response(ResponseCode.SUCCESS, "查询菜品成功", data);
    }

    @Override
    public Response getDishesByPosition(String position) {
        List<Dish> dishes = repository.findByPosition(position);
        Map<String, Object> data = new HashMap<>();
        data.put("dishes", assembler.toCollectionModel(dishes));
        return new Response(ResponseCode.SUCCESS, "查询菜品成功", data);
    }

    @Override
    public Response setDishName(String dishId, String dishName) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        if (repository.existsByDishName(dishName) && repository.existsByPosition(dish.get().getPosition())) {
            return new Response(ResponseCode.REPLICATE_DISH, "该菜品已存在", null);
        }
        dish.get().setDishName(dishName);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品名称成功", data);
    }

    @Override
    public Response setDishDescription(String dishId, String description) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        dish.get().setDescription(description);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品描述成功", data);
    }

    @Override
    public Response setDishPhotoUrl(String dishId, String photoUrl) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        dish.get().setPhotoUrl(photoUrl);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品图片链接成功", data);
    }

    @Override
    public Response setDishPosition(String dishId, String position) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        if (repository.existsByDishName(dish.get().getDishName()) && repository.existsByPosition(position)) {
            return new Response(ResponseCode.REPLICATE_DISH, "该菜品已存在", null);
        }
        dish.get().setPosition(position);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品位置成功", data);
    }

    @Override
    public Response setDishPreference(String dishId, Map<String, Object> preferenceMap) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        Preference preference = new Preference(
                parseInt(preferenceMap.get("spiciness").toString()),
                parseInt(preferenceMap.get("sourness").toString()),
                parseInt(preferenceMap.get("sweetness").toString()),
                parseInt(preferenceMap.get("bitterness").toString()));
        dish.get().setPreference(preference);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品口味成功", data);
    }

    @Override
    public Response setDishIngredients(String dishId, List<String> ingredients) {
        Optional<Dish> dish = repository.findById(dishId);
        if (dish.isEmpty()) {
            return new Response(ResponseCode.UNDEFINED_DISH, "未知菜品", null);
        }
        dish.get().setIngredients(ingredients);
        repository.save(dish.get());
        Map<String, Object> data = new HashMap<>();
        data.put("dish", assembler.toModel(dish.get()));
        return new Response(ResponseCode.SUCCESS, "修改菜品位置成功", data);
    }

    @Override
    public Response addDish(String dishName, String description, String photoUrl, String position, Double price, Map<String, Object> preferenceMap, List<String> ingredients) {
        if (repository.existsByDishName(dishName) && repository.existsByPosition(position)) {
            return new Response(ResponseCode.REPLICATE_DISH, "该菜品已存在", null);
        }
        Preference preference = new Preference(
                parseInt(preferenceMap.get("spiciness").toString()),
                parseInt(preferenceMap.get("sourness").toString()),
                parseInt(preferenceMap.get("sweetness").toString()),
                parseInt(preferenceMap.get("bitterness").toString()));
        Dish dish = new Dish(null, dishName, description, photoUrl, position, price, 0.0, preference, ingredients, new ArrayList<>());
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
