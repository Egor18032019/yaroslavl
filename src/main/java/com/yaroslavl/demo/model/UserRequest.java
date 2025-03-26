package com.yaroslavl.demo.model;

import com.yaroslavl.demo.util.Goal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;

    private String email;

    private int age;

    private double weight;

    private double height;

    @Enumerated(EnumType.STRING)
    private Goal goal;
}
