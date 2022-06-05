package com.company.ClothesProduction;

public class GreenColorFactory extends AbstractFactory{
    @Override
    public Clothing getClothing(String clothingType) {
        if(clothingType.equalsIgnoreCase("Jeans")){
            return new GreenJeans();
        }else if(clothingType.equalsIgnoreCase("Shirts")){
            return new GreenShirt();
        }
        return null;
    }
}
