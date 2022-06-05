package com.company.Newsletter;

public class Email implements Clients {
    public void handleEvent(int discount, String date) {
        System.out.println("Скидки более " + discount + "% с " + date + "!");
    }
}
