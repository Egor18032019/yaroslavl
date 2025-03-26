package com.yaroslavl.demo.controller;

import com.yaroslavl.demo.model.TotalCaloriesAndMealEatingResponse;
import com.yaroslavl.demo.service.ReportsService;
import com.yaroslavl.demo.store.entity.MealRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController {
    private final ReportsService reportsService;


    @GetMapping("/day")
    public ResponseEntity<TotalCaloriesAndMealEatingResponse> dailyTotalCaloriesAndMealsReports(
            @RequestParam Long userId, @RequestParam LocalDate date) {

        return ResponseEntity.ok(reportsService.dailyTotalCaloriesAndMealsReports(userId, date));
    }

    @GetMapping("/checking")
    public ResponseEntity<Boolean> checkingDayCalorieReports(@RequestParam Long userId) {

        Boolean isHaveDailyNorm = reportsService.checkingDayCalorieReports(userId);
        return ResponseEntity.ok(isHaveDailyNorm);
    }


    @GetMapping("/history")
    public ResponseEntity<List<MealRecord>> historicalFoodReports(@RequestParam Long userId) {
        List<MealRecord> mealRecords = reportsService.giveAllFoodEatingForUser(userId);
        return ResponseEntity.ok(mealRecords);
    }
}
