package com.example.demo.models;

import lombok.Data;

import java.util.List;

@Data
public class CarBean {
    private Brand brand;
    private List<Car> cars;
}
