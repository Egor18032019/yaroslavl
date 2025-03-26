package com.yaroslavl.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealRequest {
    private String name;

    private double caloriesPerPortion; // Калории на порцию

    private double proteins;

    private double fats;

    private double carbs;
}
