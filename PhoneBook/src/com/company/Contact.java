package com.company;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contact createNewContact(String name,String phoneNumber){
        Contact newContact= new Contact(name,phoneNumber);
        return newContact;
    }
}
