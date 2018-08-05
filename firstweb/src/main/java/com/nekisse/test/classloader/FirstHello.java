package com.nekisse.test.classloader;

public class FirstHello {

    public FirstHello() {
        printInfo();
        this.init();
    }

    public void printInfo() {
        System.out.println("FirstHello");
    }

    protected void init() {
        SecondHello sh = new SecondHello();
        sh.printInfo();
    }
}
