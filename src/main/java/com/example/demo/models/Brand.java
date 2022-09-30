package com.example.demo.models;

public enum Brand {
    //MYBRAND("whatever value you want"),
    FORD("Ford"),
    GMC("GMC"),
    FERRARI("Ferrari"),
    PORSCHE("Porsche"),
    VW("Volkswagen"),
    VOLKSWAGEN("Volkswagen"),
    GM("GM");
    private String brand;
    Brand(String brand){
        this.brand = brand;
    }
    public String dbFriendlyName(){
        return this.brand;
    }
}
