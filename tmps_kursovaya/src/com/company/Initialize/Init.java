package com.company.Initialize;

import com.company.ClothesProduction.*;
import com.company.DressMannequin.Clothes;
import com.company.DressMannequin.Dress;
import com.company.DressMannequin.Mannequins;
import com.company.Newsletter.Email;
import com.company.Newsletter.Post;
import com.company.Newsletter.ShopNewsletter;
import com.company.TerminalConnector.ProxyTerminal;
import com.company.TerminalConnector.TerminalOn;

import java.util.Scanner;

public class Init {
    private static Init instance;
    private AbstractFactory colorFactory;
    private String PASSWORD = "1234";

    private Init () {
        // SINGLETON

        System.out.println("———————————————Доброе пожаловать в магазин!——————————————");
        System.out.println("Открыть магазин ? [y / n]");
        Scanner scanner = new Scanner(System.in);
        String ans1 = scanner.nextLine();
        if ( ans1.equals("y") ) {
            System.out.println("Магазин был открыт!");
            System.out.println("—————————————————————————————————————————————————————————");
            facade();
        } else {}
    }

    public void facade () {
        // FACADE



        System.out.println("Одеть всех манекенов ? [y / n]");
        Scanner scanner = new Scanner(System.in);
        String ans1 = scanner.nextLine();
        if ( ans1.equals("y") ) {
            Dress mannequins = new Mannequins();
            Dress clothes = new Clothes(mannequins);
            clothes.dress();
            System.out.println("—————————————————————————————————————————————————————————");
        } else {}
        // DECORATOR

        
        // ABSTRACT FACTORY
        System.out.println("Произвести красные вещи или зеленые ? [RED / GREEN]");
        Scanner scanner2 = new Scanner(System.in);
        String ans2 = scanner.nextLine();
        System.out.println("—————————————————————————————————————————————————————————");

        if ( ans2.equals("RED") ) {
            colorFactory = FactoryProducer.getFactory(false);
        } else if ( ans2.equals("GREEN") ) {
            colorFactory = FactoryProducer.getFactory(true);
        } else {}

        System.out.println("Произвести джинсы или рубашки ? [JEANS / SHIRTS]");
        Scanner scanner3 = new Scanner(System.in);
        String ans3 = scanner.nextLine();
        Clothing clothes;
        System.out.println("—————————————————————————————————————————————————————————");
        if ( ans3.equals("JEANS")) {
            clothes = colorFactory.getClothing("Jeans");
            clothes.produce();
        } else if ( ans3.equals("SHIRTS") ) {
            clothes = colorFactory.getClothing("Shirts");
            clothes.produce();
        } else {}
        System.out.println("—————————————————————————————————————————————————————————");
        

        // PROXY PATTERN
        String password;
        while (true) {
            try {
                System.out.println("Введите численный пароль для терминала:");
                Scanner scanner4 = new Scanner(System.in);
                password = scanner4.nextLine();
            } catch (Exception e) {
                System.out.println("Неверный пароль! Попробуйте снова...");
                continue;
            }
            if ( !PASSWORD.equals(password) ) {
                System.out.println("Неверный пароль! Попробуйте снова...");
                continue;
            }
            TerminalOn terminal = new ProxyTerminal(PASSWORD);
            terminal.turnOn();
            break;
        }
        System.out.println("—————————————————————————————————————————————————————————");



        // OBSERVER

        int discount;
        while (true) {
            try {
                System.out.println("Выберите % скидки:");
                Scanner scanner5 = new Scanner(System.in);
                discount = scanner5.nextInt();
            } catch (Exception e) {
                System.out.println("Процент целочисленное значение!");
                continue;
            }
            if ( discount < 0 || discount > 100 ) {
                System.out.println("Процент может находится в диапазоне [0, 100]");
                continue;
            }
            break;
        }
        System.out.println("—————————————————————————————————————————————————————————");

        ShopNewsletter newsletter = new ShopNewsletter();
        newsletter.addEmailMethod(new Email());
        newsletter.addEmailMethod(new Post());

        System.out.println("Введите дату, когда начнется скидка: [dd/mm/yyyy]");
        Scanner scanner6 = new Scanner(System.in);
        String date = scanner6.nextLine();

        newsletter.setDiscounts(discount, date);

        System.out.println("—————————————————————————————————————————————————————————");
        System.out.println("————————————————————Удачного шопинга—————————————————————");
        System.out.println("—————————————————————————————————————————————————————————");


    }

    public static Init getInstance() {
        if ( instance == null ) {
            instance = new Init();
        }
        return instance;
    }
}
