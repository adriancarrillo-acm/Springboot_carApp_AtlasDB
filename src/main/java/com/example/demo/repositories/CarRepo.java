package com.example.demo.repositories;


import com.example.demo.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends MongoRepository <Car, String> {
    Optional<List<Car>> findCarByCarMake(String input);

    List<Car> findCarByCarYear(int year);
    List<Car> findCarByCarColor(String color);

}
