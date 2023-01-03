package com.fan.dishsystem.service;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.pojo.Preference;
import com.fan.dishsystem.utils.Response;

import java.util.List;
import java.util.Map;

public interface DishService {
    public Response getAll();
    public Response getDishById(String dishId);
    public Response getDishesByName(String dishName);
    public Response getDishesByPosition(String position);
    public Response setDishName(String dishId, String dishName);
    public Response setDishDescription(String dishId, String description);
    public Response setDishPhotoUrl(String dishId, String photoUrl);
    public Response setDishPosition(String dishId, String position);
    public Response setDishPreference(String dishId, Map<String, Object> preferenceMap);
    public Response setDishIngredients(String dishId, List<Ingredient> ingredients);
    public Response addDish(String dishName, String description, String photoUrl, String position, Map<String, Object> preference, List<Ingredient> ingredients);
    public Response deleteDish(String dishId);
}
