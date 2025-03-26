package com.yaroslavl.demo.store.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "MealRecord")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MealRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(
            name = "meal_record_meals",
            joinColumns = @JoinColumn(name = "meal_record_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;

    private LocalDate date;

}