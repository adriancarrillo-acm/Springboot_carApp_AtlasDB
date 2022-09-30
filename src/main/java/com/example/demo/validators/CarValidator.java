package com.example.demo.validators;

import com.example.demo.exceptions.IllegalBrandException;
import com.example.demo.models.Brand;
import com.example.demo.models.CarBean;
import org.springframework.stereotype.Component;

@Component
public class CarValidator {
    public void validateBrand(CarBean carBean) throws IllegalBrandException {
        if(!carBean.getBrand().equals(Brand.GM) && !carBean.getBrand().equals(Brand.PORSCHE)){
            // TODO throw custom exception IllegalBrandException
            throw new IllegalBrandException("Brand must be GM or GMC! You used: " + carBean.getBrand());
        }
    }
}
