package com.fan.dishsystem.controller;

import com.fan.dishsystem.service.CommentService;
import com.fan.dishsystem.utils.Response;
import com.fan.dishsystem.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@RestController
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/2 20:31
 * @version: 1.0
 */
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments/")
    /**
     * @param :
     * @return: ResponseEntity<Response>
     * @author: VenusHui
     * @description: 获取所有评论
     * @date: 2023/1/3 0:04
     */
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(commentService.getAll());
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
        return ResponseEntity.ok(commentService.getCommentById(commentId));
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
        if (Objects.equals(filter, "context")) {
            return ResponseEntity.ok(commentService.setCommentByContext(commentId, value));
        } else if (Objects.equals(filter, "score")) {
            return ResponseEntity.ok(commentService.setCommentByScore(commentId, parseDouble(value)));
        }
        return ResponseEntity.badRequest().body(new Response(ResponseCode.REQUEST_PARAM_ERROR, "请求参数错误", null));
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
        return ResponseEntity.ok(commentService.getCommentsByDishId(dishId));
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
        return ResponseEntity.ok(commentService.getCommentsByUserId(userId));
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
        Integer userId = parseInt(form.get("userId").toString());
        String context = form.get("context").toString();
        Double score = parseDouble(form.get("score").toString());
        return ResponseEntity.ok(commentService.addComment(dishId, userId, context, score));
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
        return ResponseEntity.ok(commentService.deleteComment(commentId));
    }

}
