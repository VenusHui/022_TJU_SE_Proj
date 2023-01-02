package com.fan.backend.controller.dish;

import com.fan.backend.service.DishSystemService;
import com.fan.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 0:22
 * @version: 1.0
 */
public class CommentController {

    @Autowired
    DishSystemService dishSystemService;

    @GetMapping("/comments/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取所有评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> getAllComments() {
        return ResponseEntity.ok(dishSystemService.getAllComments());
    }

    @GetMapping("/comments/{commentId}/")
    /**
     * @param commentId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> getComment(@PathVariable String commentId) {
        return ResponseEntity.ok(dishSystemService.getComment(commentId));
    }

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
    public ResponseEntity<Response> setComment(@PathVariable String commentId,
                               @RequestParam(value = "filter") String filter,
                               @RequestParam(value = "value") String value) {
        return ResponseEntity.ok(dishSystemService.setComment(commentId, filter, value));
    }

    @GetMapping("/dishes/{dishId}/comments/")
    /**
     * @param dishId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定菜品的所有评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> getCommentsByDishId(@PathVariable String dishId) {
        return ResponseEntity.ok(dishSystemService.getCommentsByDishId(dishId));
    }

    @GetMapping("/users/{userId}/comments/")
    /**
     * @param userId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取指定用户的所有评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> getCommentsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(dishSystemService.getCommentsByUserId(userId));
    }

    @PostMapping("/dishes/{dishId}/comments/")
    /**
     * @param dishId:
     * @param form:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 向指定菜品添加评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> addComment(@PathVariable String dishId,
                               @RequestParam Map<String, Object> form) {
        return ResponseEntity.ok(dishSystemService.addComment(dishId, form));
    }

    @DeleteMapping("/comments/{commentId}/")
    /**
     * @param commentId:
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 删除指定评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> deleteComment(@PathVariable String commentId) {
        return ResponseEntity.ok(dishSystemService.deleteComment(commentId));
    }
}
