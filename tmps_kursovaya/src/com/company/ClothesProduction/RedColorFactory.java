package com.company.ClothesProduction;

public class RedColorFactory extends AbstractFactory{
    @Override
    public Clothing getClothing(String clothingType) {
        if(clothingType.equalsIgnoreCase("Jeans")){
            return new RedJeans();
        }else if(clothingType.equalsIgnoreCase("Shirts")){
            return new RedShirt();
        }
        return null;
    }
}
