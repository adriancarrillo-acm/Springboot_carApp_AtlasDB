package com.example.demo.controllers;

import com.example.demo.mappers.CarMapper;
import com.example.demo.models.Car;
import com.example.demo.models.CarBean;
import com.example.demo.repositories.CarRepo;
import com.example.demo.requests.AddCarsRequestDto;
import com.example.demo.responses.CarResponseDto;
import com.example.demo.services.CarService;
import com.example.demo.validators.CarValidator;
import com.example.demo.exceptions.IllegalBrandException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarsController {

    private final CarRepo carRepo;
    private final CarMapper carMapper;
    private final CarValidator carValidator;
    private final CarService carService;

    public CarsController(CarRepo carRepo, CarMapper carMapper, CarValidator carValidator, CarService carService) {
        this.carRepo = carRepo;
        this.carMapper = carMapper;
        this.carValidator = carValidator;
        this.carService = carService;
    }


    @GetMapping("/getCars")
    public List<Car> getCars(){
        return carRepo.findAll();
    }

    @GetMapping(value = "/getCars", params = "id")
    public CarResponseDto getCar(@RequestParam(name = "id") String id) throws Exception {
        CarResponseDto response = new CarResponseDto();
        Car car = carRepo.findById(id).orElse(null);
        if(car != null){
            List<Car> cars = new ArrayList<>();
            cars.add(car);
            response.setCars(cars);
            response.setMyMessage("Car Found!!!");
            response.setRecordsFound(cars.size());
        }else{
            response.setMyMessage("No Car Found :(");
        }
        return response;
    }

    @GetMapping(value = "/getCars", params = "carMake")
    public List<Car> getMake(@RequestParam("carMake") String carMake) throws IllegalBrandException {
        CarBean carBean = new CarBean();
        carMapper.brandMapper(carBean, carMake);
        carValidator.validateBrand(carBean);
        carService.processRequest(carBean);
        return carBean.getCars();
    }

    @GetMapping(value = "/getCars", params = "carYear")
    public List<Car> getYear(@RequestParam("carYear") int carYear) throws Exception {
        if(carRepo.findCarByCarYear(carYear).isEmpty()){
            throw new Exception("No Cars of That Year Found!!!");
        }
        return carRepo.findCarByCarYear(carYear);
    }

    @GetMapping(value = "/getCars", params = "carColor")
    public List<Car> getColor(@RequestParam("carColor") String carColor) throws Exception {
        if(carRepo.findCarByCarColor(carColor).isEmpty()){
            throw new Exception("No Cars of That Color Found!!!");
        }
        return carRepo.findCarByCarColor(carColor);
    }

    @PostMapping("/addCar")
    public String addCar(@RequestBody Car car){
        carRepo.save(car);
        return "Added Car!   Details: " + car.getCarMake() + " " + car.getCarModel();
    }

    @PostMapping("/addCars")
    public String addCars(@RequestBody AddCarsRequestDto requestDto){
        for( Car car: requestDto.getCars()){
            carRepo.save(car);
        }
        return "Cars Added!";
    }

    @PutMapping("/editCar")
    public String editCar(@RequestBody Car car){
        if(carRepo.existsById(car.getId())){
            car.setCarMake(car.getCarMake());
            car.setCarModel(car.getCarModel());
            car.setCarYear(car.getCarYear());
            car.setCarColor(car.getCarColor());
            carRepo.save(car);
        }else{
            return "Car Not Found";
        }
        return "Car Edited";
    }

//    @DeleteMapping("/deleteCar")
//    public String deleteCar(@RequestBody Car car) {
//        carRepo.deleteById(car.getId());
//        return car.toString() + " deleted";
//    }

    @DeleteMapping(value = "/deleteCar", params = "id")
    public String deleteCar(@RequestParam("id") String id) {
        Car car = carRepo.findById(id).orElse(null);
        if(car != null){
            carRepo.deleteById(id);
            return car.toString() + "DELETED";
        }else{
            return "The ID Doesn't exist. Try again :(";
        }
    }

}
