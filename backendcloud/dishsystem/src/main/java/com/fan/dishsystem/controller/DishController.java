package com.fan.dishsystem.controller;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.service.DishService;
import com.fan.dishsystem.utils.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 21:35
 * @version: 1.0
 */
public class DishController {
    @Autowired
    DishService dishService;

    @GetMapping("/dishes/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询所有菜品
     * @date: 2023/1/1 23:04
     */
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(dishService.getAll());
    }

    @PostMapping("/dishes/")
    /**
     * @param form:
     *            dishName:
     *            description:
     *            photoUrl:
     *            position:
     *
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 添加菜品
     * @date: 2023/1/1 23:04
     */
    public ResponseEntity<Response> addDish(@RequestParam Map<String, Object> form,
                                            @RequestParam(value = "ingredients") List<String> ingredientList) {
        String dishName = form.get("dishName").toString();
        String description = form.get("description").toString();
        String photoUrl = form.get("photoUrl").toString();
        String position = form.get("position").toString();

        Map<String, Object> preferenceMap = new HashMap<>();
        JSONObject jsonObject = new JSONObject(form.get("preference").toString());
        for (String key : jsonObject.keySet()) {
            preferenceMap.put(key, jsonObject.get(key));
        }
        List<Ingredient> ingredients = ingredientList.stream()
                .map(Ingredient::new).collect(Collectors.toList());
        return ResponseEntity.ok(dishService.addDish(dishName, description, photoUrl, position, preferenceMap, ingredients));
    }
}
