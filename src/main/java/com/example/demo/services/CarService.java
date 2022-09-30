package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.CarBean;
import com.example.demo.repositories.CarRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
    private final CarRepo carRepo;

    public void processRequest(CarBean carBean){
        String carMake = carBean.getBrand().dbFriendlyName();
        List<Car> carList = carRepo.findCarByCarMake(carMake).orElse(new ArrayList<>());
        carBean.setCars(carList);
    }
}
