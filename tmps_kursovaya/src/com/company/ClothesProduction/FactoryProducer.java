package com.company.ClothesProduction;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean isGreenClothing){
        if(isGreenClothing){
            return new GreenColorFactory();
        }else{
            return new RedColorFactory();
        }
    }
}
