package com.example.demo.validators;

import com.example.demo.exceptions.IllegalBrandException;
import com.example.demo.models.Brand;
import com.example.demo.models.CarBean;
import org.springframework.stereotype.Component;

@Component
public class CarValidator {
    public void validateBrand(CarBean carBean) throws IllegalBrandException {
        if( !carBean.getBrand().equals(Brand.CHEVY) && !carBean.getBrand().equals(Brand.CHEVROLET) && !carBean.getBrand().equals(Brand.PORSCHE)){
            // TODO throw custom exception IllegalBrandException
            throw new IllegalBrandException("Brand must be Chevy or Porsche! You used: " + carBean.getBrand());
        }
    }
}
