package com.company.DressMannequin;

public class BaseDresser implements Dress{
    protected Dress d;

    public BaseDresser(Dress d) {
        this.d = d;
    }

    @Override
    public void dress() {
        this.d.dress();
    }
}
