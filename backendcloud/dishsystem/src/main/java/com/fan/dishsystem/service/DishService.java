package com.fan.dishsystem.service;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.utils.Response;

import java.util.List;
import java.util.Map;

public interface DishService {
    public Response getAll();
    public Response getDish(String dishId);
    public Response setDish(String dishId);
    public Response addDish(String dishName, String description, String photoUrl, String position, Map<String, Object> preference, List<Ingredient> ingredients);
    public Response deleteDish(String dishId);
}
