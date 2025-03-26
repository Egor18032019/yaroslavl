package com.yaroslavl.demo.service;

import com.yaroslavl.demo.model.UserRequest;
import com.yaroslavl.demo.store.entity.User;
import com.yaroslavl.demo.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequest user) {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAge(user.getAge());
        userEntity.setHeight(user.getHeight());
        userEntity.setWeight(user.getWeight());
        userEntity.setGoal(user.getGoal());
        userEntity.setDailyCalorieNorm(calculateDailyCalorieNorm(user));
        return userRepository.save(userEntity);
    }

    private double calculateDailyCalorieNorm(UserRequest user) {
        double bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge();

        return switch (user.getGoal()) {
            case WeightLoss -> bmr * 0.8;
            case Maintenance -> bmr;
            case WeightGain -> bmr * 1.2;
            default -> throw new IllegalArgumentException("Неизвестная цель");
        };
    }
}