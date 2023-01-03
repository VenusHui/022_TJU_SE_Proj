package com.fan.backend.pojo;

import com.fan.backend.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("fander-dishsystem")
public interface DishSystem {

    @GetMapping("/dishes/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询所有菜品
     * @date: 2023/1/1 23:04
     */
    public Response getDishes(@RequestParam(value = "filter", required = false) String filter,
                                              @RequestParam(value = "value", required = false) String value);

    @GetMapping("/dishes/{dishId}/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 查询指定菜品信息
     * @date: 2023/1/2 23:44
     */
    public Response getDish(@PathVariable String dishId);

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
    public Response addDish(@RequestParam Map<String, Object> form);

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
    public Response setDish(@PathVariable String dishId,
                                            @RequestParam(value = "filter") String filter,
                                            @RequestParam(value = "value") String value);

    @DeleteMapping("/dishes/{dishId}/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定菜品
     * @date: 2023/1/3 0:02
     */
    public Response deleteDish(@PathVariable String dishId);
    @GetMapping("/comments/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取所有评论
     * @date: 2023/1/3 0:04
     */
    public Response getAllComments();

    @GetMapping("/comments/{commentId}/")
    /**
     * @param commentId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定评论
     * @date: 2023/1/3 0:04
     */
    public Response getComment(@PathVariable String commentId);

    @PutMapping("/comments/{commentId}/")
    /**
     * @param commentId:
     * @param filter:
     * @param value:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 更新评论信息
     * @date: 2023/1/3 0:04
     */
    public Response setComment(@PathVariable String commentId,
                                               @RequestParam(value = "filter") String filter,
                                               @RequestParam(value = "value") String value);

    @GetMapping("/dishes/{dishId}/comments/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定菜品的所有评论
     * @date: 2023/1/3 0:04
     */
    public Response getCommentsByDishId(@PathVariable String dishId);

    @GetMapping("/users/{userId}/comments/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定用户的所有评论
     * @date: 2023/1/3 0:04
     */
    public Response getCommentsByUserId(@PathVariable Integer userId);

    @PostMapping("/dishes/{dishId}/comments/")
    /**
     * @param dishId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 向指定菜品添加评论
     * @date: 2023/1/3 0:04
     */
    public Response addComment(@PathVariable String dishId,
                                               @RequestParam Map<String, Object> form);

    @DeleteMapping("/comments/{commentId}/")
    /**
     * @param commentId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定评论
     * @date: 2023/1/3 0:04
     */
    public Response deleteComment(@PathVariable String commentId);
}
