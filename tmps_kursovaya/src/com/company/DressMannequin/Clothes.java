package com.company.DressMannequin;

public class Clothes extends BaseDresser{

    public Clothes(Dress d) {
        super(d);
    }

    public void dress() {
        super.dress();
        System.out.println("The mannequins have been dressed!");
    }
}
