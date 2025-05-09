package com.company;

import java.util.ArrayList;

public class Device{
    private String name;
    private ArrayList<Contact> myContacts;

    public Device(String name){
        this.name = name;
        this.myContacts = new ArrayList<Contact>();

    }

    public String getName() {
        return name;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact Already Exists");
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }


    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size();i++){
            Contact eachContact = this.myContacts.get(i);
            if (eachContact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public boolean updateContact(Contact previousContact, Contact newContact){
        int foundedPosition = findContact(previousContact);
        if(foundedPosition < 0){
            System.out.println(previousContact.getName() +" Wasn't Found");
            return false;
        }else{
            this.myContacts.set(foundedPosition,newContact);
            System.out.println(previousContact.getName()+ " was replaced with "+ newContact.getName());
            return true;
        }
    }

    public String queryContact(Contact contact){
        if (findContact(contact) >=0){
            return contact.getName();
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int foundedPosition= findContact(contact);
        if (foundedPosition < 0){
            System.out.println(contact.getName() + "wasn't found!");
            return false;
        }else{
            this.myContacts.remove(foundedPosition);
            return true;
        }
    }

    public Contact queryContact(String name){
        int position= findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for(int i=0; i< this.myContacts.size();i++){
            System.out.println((i+1) + "."+
                    " Name: "+ this.myContacts.get(i).getName() +
                    " Number: "+this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void printMessage(){
        System.out.println("Currently Running on " + name);
    }

}
