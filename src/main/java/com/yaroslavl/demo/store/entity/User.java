package com.yaroslavl.demo.store.entity;

import com.yaroslavl.demo.util.Goal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;
    @Column()
    private String email;
    @Column()
    private int age;
    @Column()
    private double weight;
    @Column()
    private double height;
    @Column()
    @Enumerated(EnumType.STRING)
    private Goal goal; // Цель: Похудение, Поддержание, Набор массы
    @Column()
    private double dailyCalorieNorm;

}