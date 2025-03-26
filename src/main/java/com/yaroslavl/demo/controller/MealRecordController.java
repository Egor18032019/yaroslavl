package com.yaroslavl.demo.controller;

import com.yaroslavl.demo.service.MealService;
import com.yaroslavl.demo.store.entity.Meal;
import com.yaroslavl.demo.store.entity.MealRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class MealRecordController {

    private final MealService mealService;

    // запись приема пищи
    @PostMapping("/record")
    public ResponseEntity<MealRecord> addMealRecord(
            @RequestParam Long userId,
            @RequestParam List<String> mealNames,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        MealRecord mealRecord = mealService.addMealRecord(userId, mealNames, date);
        return ResponseEntity.status(HttpStatus.CREATED).body(mealRecord);
    }

    //создание блюда
    @PostMapping("/meal")
    public ResponseEntity<Meal> createMeal(
            @RequestParam String name,
            @RequestParam double caloriesPerPortion,
            @RequestParam double proteins,
            @RequestParam double fats,
            @RequestParam double carbs) {
        Meal meal = mealService.createMeal(name, caloriesPerPortion, proteins, fats, carbs);
        return ResponseEntity.status(HttpStatus.CREATED).body(meal);
    }
}