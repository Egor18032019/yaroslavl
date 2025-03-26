package com.yaroslavl.demo.store.repository;

import com.yaroslavl.demo.store.entity.MealRecord;
import com.yaroslavl.demo.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MealRecordRepository extends JpaRepository<MealRecord, Long> {
    Optional<MealRecord> findByUserAndDate(User user, LocalDate date);
    Optional <List<MealRecord>> findByUserOrderByDateDesc(User user);
}