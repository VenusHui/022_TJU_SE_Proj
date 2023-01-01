package com.fan.dishsystem.controller;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.service.DishService;
import com.fan.dishsystem.utils.Response;
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
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;

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
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(dishService.getAll());
    }

    @PostMapping("/dishes/")
    public ResponseEntity<Response> addDish(@RequestParam Map<String, Object> form) {
        String dishName = form.get("dishName").toString();
        String description = form.get("description").toString();
        String photoUrl = form.get("photoUrl").toString();
        String position = form.get("position").toString();

        Map<String, Integer> preferenceMap = new HashMap<>();
        Object preferenceObject = form.get("preference");
        Class<?> preferenceObjectClass = preferenceObject.getClass();
        Field[] fields = preferenceObjectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = null;
            try {
                fieldValue = field.get(preferenceObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldValue instanceof Integer) {
                preferenceMap.put(fieldName, (Integer) fieldValue);
            }
        }

        List<Ingredient> ingredients = Stream.of(form.get("ingredients"))
                .map(obj -> new Ingredient(obj.toString())).toList();

    }
}
