package com.fan.dishsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("dish")
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 21:26
 * @version: 1.0
 */
public class Dish {
    @Id
    private String _id;
    private String dishName;
    private String description;
    private String photoUrl;
    private String position;
    private Double price;
    private Double score;
    private Preference preference;
    private List<String> ingredients;
    private List<Comment> comments;
}
