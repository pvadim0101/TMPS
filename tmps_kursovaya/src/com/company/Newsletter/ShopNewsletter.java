package com.company.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class ShopNewsletter implements Newsletter {
    int discount;
    String date;

    List<Clients> observers = new ArrayList<>();

    public void setDiscounts(int discount, String date) {
        this.discount = discount;
        this.date = date;
        notifyClients();
    }

    @Override
    public void addEmailMethod(Clients o) {
        observers.add(o);
    }

    @Override
    public void removeEmailMethod(Clients o) {
        observers.remove(o);
    }

    @Override
    public void notifyClients() {
        for(Clients o: observers) {
            o.handleEvent(discount, date);
        }
    }
}
