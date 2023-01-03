package com.fan.dishsystem.controller;

import com.fan.dishsystem.pojo.Ingredient;
import com.fan.dishsystem.service.DishService;
import com.fan.dishsystem.utils.Response;
import com.fan.dishsystem.utils.ResponseCode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public ResponseEntity<Response> getDishes(@RequestParam(value = "filter", required = false) String filter,
                                              @RequestParam(value = "value", required = false) String value) {
        if (filter.equals("dishName")) {
            return ResponseEntity.ok(dishService.getDishesByName(value));
        }
        else if (filter.equals("position")) {
            return ResponseEntity.ok(dishService.getDishesByPosition(value));
        }
        return ResponseEntity.ok(dishService.getAll());
    }

    @GetMapping("/dishes/{dishId}/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定菜品信息
     * @date: 2023/1/2 23:44
     */
    public ResponseEntity<Response> getDish(@PathVariable String dishId) {
        return ResponseEntity.ok(dishService.getDishById(dishId));
    }

    @PostMapping("/dishes/")
    /**
     * @param form:
     *            String dishName: 菜品名称
     *            String description: 菜品描述
     *            String photoUrl: 菜品图片链接
     *            String position: 菜品位置
     *            Map<String, Object> preference: 菜品口味
     *                  spiciness: 辣
     *                  sourness: 酸
     *                  sweetness: 甜
     *                  bitterness: 苦
     *            List<String> ingredients: 原材料列表
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

    @PutMapping("/dishes/{dishId}")
    /**
     * @param dishId:
     * @param filter:
     * @param value:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 根据筛选字段修改菜品信息
     * @date: 2023/1/3 0:00
     */
    public ResponseEntity<Response> setDish(@PathVariable String dishId,
                                            @RequestParam(value = "filter") String filter,
                                            @RequestParam(value = "value") String value) {
        if (Objects.equals(filter, "dishName")) {
            return ResponseEntity.ok(dishService.setDishName(dishId, value));
        } else if (Objects.equals(filter, "description")) {
            return ResponseEntity.ok(dishService.setDishDescription(dishId, value));
        } else if (Objects.equals(filter, "photoUrl")) {
            return ResponseEntity.ok(dishService.setDishPhotoUrl(dishId, value));
        } else if (Objects.equals(filter, "position")) {
            return ResponseEntity.ok(dishService.setDishPosition(dishId, value));
        } else if (Objects.equals(filter, "preference")) {
            Map<String, Object> preferenceMap = new HashMap<>();
            JSONObject jsonObject = new JSONObject(value);
            for (String key : jsonObject.keySet()) {
                preferenceMap.put(key, jsonObject.get(key));
            }
            return ResponseEntity.ok(dishService.setDishPreference(dishId, preferenceMap));
        } else if (Objects.equals(filter, "ingredients")) {
            String[] items = value.split(",");
            List<Ingredient> ingredients = new ArrayList<>(Arrays.asList(items)).stream()
                    .map(Ingredient::new).collect(Collectors.toList());
            return ResponseEntity.ok(dishService.setDishIngredients(dishId, ingredients));
        }
        return ResponseEntity.badRequest().body(new Response(ResponseCode.REQUEST_PARAM_ERROR, "请求参数错误", null));
    }

    @DeleteMapping("/dishes/{dishId}/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定菜品
     * @date: 2023/1/3 0:02
     */
    public ResponseEntity<Response> deleteDish(@PathVariable String dishId) {
        return ResponseEntity.ok(dishService.deleteDish(dishId));
    }
}
