package com.yaroslavl.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalCaloriesAndMealEatingResponse {
    private Double calories;
    private Integer mealEating;
}
