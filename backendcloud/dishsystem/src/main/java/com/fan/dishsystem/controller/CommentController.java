package com.fan.dishsystem.controller;

import com.fan.dishsystem.service.CommentService;
import com.fan.dishsystem.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * @author climo
 * @version 1.0
 * @date 2023/1/2 10:19
 */
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/")
    public ResponseEntity<Response> addComment(@RequestParam Map<String, Object> form) throws ParseException {
        Integer userId = parseInt(form.get("userId").toString());
        String context = form.get("context").toString();
        Double score = (Double) form.get("score");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date commentDate = simpleDateFormat.parse(form.get("commentDate").toString());

        return ResponseEntity.ok(commentService.addComment(userId, context, score, commentDate));
    }
}
