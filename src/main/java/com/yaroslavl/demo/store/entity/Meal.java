package com.yaroslavl.demo.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Meal")
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( unique = true)
    private String name;
    @Column()
    private double caloriesPerPortion; // Калории на порцию
    @Column()
    private double proteins;
    @Column()
    private double fats;
    @Column()
    private double carbs;

}