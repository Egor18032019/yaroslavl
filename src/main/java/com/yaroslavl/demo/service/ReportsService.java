package com.yaroslavl.demo.service;

import com.yaroslavl.demo.exception.ResourceNotFoundException;
import com.yaroslavl.demo.model.TotalCaloriesAndMealEatingResponse;
import com.yaroslavl.demo.store.entity.Meal;
import com.yaroslavl.demo.store.entity.MealRecord;
import com.yaroslavl.demo.store.entity.User;
import com.yaroslavl.demo.store.repository.MealRecordRepository;
import com.yaroslavl.demo.store.repository.MealRepository;
import com.yaroslavl.demo.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportsService {

    private final MealRecordRepository mealRecordRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    /**
     * Считает отчет за день с суммой всех калорий и приемов пищи;
     *
     * @param userId Пользователь
     * @param date   за какой день
     * @return Отчет с суммой калорий и кол-во приемов пищи
     */
    public TotalCaloriesAndMealEatingResponse dailyTotalCaloriesAndMealsReports(Long userId, LocalDate date) {
        System.out.println("Generating daily reports");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден!"));
        MealRecord mealRecord = mealRecordRepository.findByUserAndDate(user, date)
                .orElseThrow(() -> new ResourceNotFoundException("Данных за день не найдено!"));
        Double totalCalories = mealRecord.getMeals().stream().mapToDouble(Meal::getCaloriesPerPortion).sum();
        TotalCaloriesAndMealEatingResponse totalCaloriesAndMealEatingResponse = new TotalCaloriesAndMealEatingResponse();
        totalCaloriesAndMealEatingResponse.setCalories(totalCalories);
        totalCaloriesAndMealEatingResponse.setMealEating(mealRecord.getMeals().size());
        return totalCaloriesAndMealEatingResponse;
    }

    /**
     * Считает отчет за день, если все данные собраны, то выдает результат в виде true/false;
     *
     * @param userId Пользователь
     * @return true если калорий не превышено, иначе false;
     */
    public Boolean checkingDayCalorieReports(Long userId) {
        System.out.println("Checking calories");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден!"));
        MealRecord mealRecord = mealRecordRepository.findByUserAndDate(user, LocalDate.now())
                .orElseThrow(() -> new ResourceNotFoundException("Данных за день не найдено!"));
        double totalCalories = mealRecord.getMeals().stream().mapToDouble(Meal::getCaloriesPerPortion).sum();
        return (totalCalories <= user.getDailyCalorieNorm());
    }

    public List<MealRecord> giveAllFoodEatingForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден!"));
        List<MealRecord> mealRecord = mealRecordRepository.findByUserOrderByDateDesc(user).orElse(new ArrayList<>());
        return mealRecord;
    }
}
