package com.yaroslavl.demo.service;

import com.yaroslavl.demo.exception.ResourceNotFoundException;
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
public class MealService {

    private final MealRecordRepository mealRecordRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    public Meal createMeal(String name, double caloriesPerPortion, double proteins, double fats, double carbs) {
        Meal meal = new Meal();
        meal.setName(name);
        meal.setCaloriesPerPortion(caloriesPerPortion);
        meal.setProteins(proteins);
        meal.setFats(fats);
        meal.setCarbs(carbs);
        return mealRepository.save(meal);
    }

    public MealRecord addMealRecord(Long userId, List<String> mealNames, LocalDate date) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));

        MealRecord meals = mealRecordRepository.findByUserAndDate(user, date)
                .orElse(new MealRecord());
        if (meals.getId() == null) {
            meals.setUser(user);
            meals.setDate(date);
            meals.setMeals(new ArrayList<>());
        }

        for (String name : mealNames) {
            Meal meal = mealRepository.findByName(name)
                    .orElseThrow(() -> new ResourceNotFoundException("Блюдо " + name + " не найдено."));
            meals.getMeals().add(meal);
        }

        return mealRecordRepository.save(meals);
    }


}