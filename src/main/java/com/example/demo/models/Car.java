package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document("cars")
public class Car {
    @Id
    private String id;
    @Field
    private String carMake;
    @Field
    private String carModel;
    @Field
    private int carYear;
    @Field
    private String carColor;

    @Override
    public String toString() {
        return "Car:" + "\n" +
                "id = '" + id + '\'' + "\n" +
                "carMake = '" + carMake + '\'' + "\n" +
                "carModel = '" + carModel + '\'' + "\n" +
                "carYear = " + carYear + "\n" +
                "carColor = '" + carColor + '\'' + "\n" + "\n";
    }
//    public Car(String carMake, String carModel, int carYear, String carColor) {
//        this.carMake = carMake;
//        this.carModel = carModel;
//        this.carYear = carYear;
//        this.carColor = carColor;
//    }
//
//
//    @Override
//    public String toString() {
//        return String.format("Car[id='%s', carMake='%s', carModel='%s', carYear='%s', carColor='%s']", id, carMake, carModel, carYear, carColor);
//    }
}


