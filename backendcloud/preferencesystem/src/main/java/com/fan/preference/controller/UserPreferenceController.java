package com.fan.preference.controller;

import com.fan.preference.service.UserPreferenceService;
import com.fan.preference.utils.Response;
import com.fan.preference.utils.ResponseCode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 16:37
 * @version: 1.0
 */
public class UserPreferenceController {

    @Autowired
    UserPreferenceService userPreferenceService;

    @GetMapping("/preference/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询所有偏好信息
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> getAllUserPreference() {
        return ResponseEntity.ok(userPreferenceService.getAllUserPreferences());
    }

    @GetMapping("/preference/{preferenceId}/")
    /**
     * @param preferenceId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定偏好信息
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> getUserPreference(@PathVariable String preferenceId) {
        return ResponseEntity.ok(userPreferenceService.getUserPreference(preferenceId));
    }

    @GetMapping("/users/{userId}/preference/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定用户偏好信息
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> getUserPreferenceByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(userPreferenceService.getUserPreferenceByUserId(userId));
    }

    @PostMapping("/users/{userId}/preference/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 新建用户偏好信息
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> addUserPreference(@PathVariable Integer userId) {
        return ResponseEntity.ok(userPreferenceService.addUserPreference(userId));
    }

    @PatchMapping("/preference/{preferenceId}/")
    /**
     * @param preferenceId:
     * @param filter:
     * @param value:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 设置用户偏好信息：地区 / 口味
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> setUserPreference(@PathVariable String preferenceId,
                                                      @RequestParam(value = "filter") String filter,
                                                      @RequestParam(value = "value") String value) {
        if (Objects.equals(filter, "religion")) {
            return ResponseEntity.ok(userPreferenceService.setReligion(preferenceId, value));
        } else if (Objects.equals(filter, "preference")) {
            Map<String, Object> preferenceMap = new HashMap<>();
            JSONObject jsonObject = new JSONObject(value);
            for (String key : jsonObject.keySet()) {
                preferenceMap.put(key, jsonObject.get(key));
            }
            return ResponseEntity.ok(userPreferenceService.setPreference(preferenceId, preferenceMap));
        }
        return ResponseEntity.badRequest().body(new Response(ResponseCode.REQUEST_PARAM_ERROR, "请求参数错误", null));
    }

    @PostMapping("/preference/{preferenceId}/liked/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 添加喜欢的菜品
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> addLikedDish(@PathVariable String preferenceId,
                                                 @RequestParam Map<String, Object> form) {
        String dishId = form.get("dishId").toString();
        return ResponseEntity.ok(userPreferenceService.addLikedDish(preferenceId, dishId));
    }

    @PostMapping("/preference/{preferenceId}/ate/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 添加吃过的但未评论的菜品
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> addAteDishNotCommented(@PathVariable String preferenceId,
                                               @RequestParam Map<String, Object> form) {
        String dishId = form.get("dishId").toString();
        return ResponseEntity.ok(userPreferenceService.addAteDishNotCommented(preferenceId, dishId));
    }

    @PatchMapping("/preference/{preferenceId}/ate/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 添加吃过且评论过的菜品
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> addAteDishCommented(@PathVariable String preferenceId,
                                                        @RequestParam Map<String, Object> form) {
        String dishId = form.get("dishId").toString();
        return ResponseEntity.ok(userPreferenceService.addAteDishCommented(preferenceId, dishId));
    }

    @PostMapping("/preference/{preferenceId}/allergens/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 添加忌口
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> addAllergen(@PathVariable String preferenceId,
                                                @RequestParam Map<String, Object> form) {
        String ingredient = form.get("ingredient").toString();
        return ResponseEntity.ok(userPreferenceService.addAllergen(preferenceId, ingredient));
    }

    @DeleteMapping("/preference/{preferenceId}/liked/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 移除喜欢的菜品
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> deleteLikedDish(@PathVariable String preferenceId,
                                                    @RequestParam Map<String, Object> form) {
        String dishId = form.get("dishId").toString();
        return ResponseEntity.ok(userPreferenceService.deleteLikedDish(preferenceId, dishId));
    }

    @DeleteMapping("/preference/{preferenceId}/allergens/")
    /**
     * @param preferenceId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 移除忌口
     * @date: 2023/1/3 23:01
     */
    public ResponseEntity<Response> deleteAllergen(@PathVariable String preferenceId,
                                                   @RequestParam Map<String, Object> form) {
        String ingredient = form.get("ingredient").toString();
        return ResponseEntity.ok(userPreferenceService.deleteAllergen(preferenceId, ingredient));
    }
}
