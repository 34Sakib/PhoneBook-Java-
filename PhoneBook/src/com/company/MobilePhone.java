package com.company;

import java.util.ArrayList;

public abstract class MobilePhone extends Device implements Ibalance {
    private String model;
    private String myNumber;

    @Override
    public void checkBalance() {
        System.out.println("Current Balance= 10$");
    }

    public MobilePhone(String name, String model, String myNumber) {
        super(name);
        this.model = model;
        this.myNumber = myNumber;
    }

    @Override
    public void printMessage() {
        System.out.println("Currently Running on "+ super.getName() + " " + model);
    }
}
