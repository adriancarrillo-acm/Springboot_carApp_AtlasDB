package com.example.demo.responses;

import com.example.demo.models.Car;
import lombok.Data;

import java.util.List;

@Data
public class CarResponseDto {
    List<Car> cars;
    String myMessage;
    int recordsFound;
}
