package com.example.demo.mappers;

import com.example.demo.models.Brand;
import com.example.demo.models.CarBean;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public void brandMapper(final CarBean carBean, final String carMake){
        Brand carBrand = Brand.valueOf(carMake.toUpperCase());
        carBean.setBrand(carBrand);
    }
}
