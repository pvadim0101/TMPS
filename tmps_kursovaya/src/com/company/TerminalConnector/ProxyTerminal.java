package com.company.TerminalConnector;
public class ProxyTerminal implements TerminalOn{
    private String password;
    private RealTerminal realProject;

    public ProxyTerminal(String password) {
        this.password = password;
    }

    @Override
    public void turnOn() {
        if (realProject == null && password.equals("1234")) {
            realProject = new RealTerminal();
        } else if ( !password.equals("1234") ) {
            System.out.println("The password is incorrect!");
        } else {
            realProject.turnOn();
        }
    }
}
