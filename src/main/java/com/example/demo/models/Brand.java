package com.example.demo.models;

public enum Brand {
    //MYBRAND("whatever value you want"),
    FORD("Ford"),
    GMC("GMC"),
    FERRARI("Ferrari"),
    VW("Volkswagen"),
    VOLKSWAGEN("Volkswagen"),
    CHEVROLET("Chevrolet"),
    CHEVY("Chevrolet"),
    HONDA("Honda"),
    BUGATTI("Bugatti"),
    DODGE("Dodge"),
    LAMBORGHINI("Lamborghini"),
    BUICK("Buick"),
    MERCEDES_BENZ("Mercedes-Benz"),
    MERCEDES("Mercedes-Benz"),
    BENZ("Mercedes-Benz"),
    SUBARU("Subaru"),
    TOYOTA("Toyota"),
    MITSUBISHI("Mitsubishi"),
    HUMMER("Hummer"),
    NISSAN("Nissan"),
    AUDI("Audi"),
    BMW("BMW"),
    INFINITY("Infinity"),
    PORSCHE("Porsche");
    private String brand;
    Brand(String brand){
        this.brand = brand;
    }
    public String dbFriendlyName(){
        return this.brand;
    }
}
