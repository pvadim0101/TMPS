package com.company.TerminalConnector;

public class RealTerminal implements TerminalOn{

    private java.util.Date date = new java.util.Date();
    public RealTerminal() {
        load();
    }

    public void load() {
        System.out.println("Terminal has been connect on " + date);
    }

    @Override
    public void turnOn() {
        System.out.println("Terminal is ON");
    }
}
