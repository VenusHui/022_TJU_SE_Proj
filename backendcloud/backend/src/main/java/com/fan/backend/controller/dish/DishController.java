package com.fan.backend.controller.dish;

import com.fan.backend.service.DishSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 0:22
 * @version: 1.0
 */
public class DishController {

    @Autowired
    DishSystemService dishSystemService;

    @GetMapping("/dishes/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询所有菜品
     * @date: 2023/1/1 23:04
     */
    public ResponseEntity<Response> getAllDishes() {
        return ResponseEntity.ok(dishSystemService.getAllDishes());
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
        return ResponseEntity.ok(dishSystemService.getDish(dishId));
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
        return ResponseEntity.ok(dishSystemService.addDish(form, ingredientList));
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
        return ResponseEntity.ok(dishSystemService.setDish(dishId, filter, value));
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
        return ResponseEntity.ok(dishSystemService.deleteDish(dishId));
    }
}
