package com.example.demo.requests;

import com.example.demo.models.Car;
import lombok.Data;

import java.util.List;

@Data
public class AddCarsRequestDto {
    private List<Car> cars;
}
