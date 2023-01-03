package com.fan.preference.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_preference")
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 15:55
 * @version: 1.0
 */
public class UserPreference {
    @Id
    private String _id;
    private String religion;
    private Preference preference;
    private List<String> likedDishes;
    private List<String> ateDishesCommented;
    private List<String> ateDishesNotCommented;
    private List<String> allergens;
}
