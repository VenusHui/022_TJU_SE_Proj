package com.fan.preference.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/1 21:25
 * @version: 1.0
 */
public class Preference {
    private Integer spiciness;
    private Integer sourness;
    private Integer sweetness;
    private Integer bitterness;
}
