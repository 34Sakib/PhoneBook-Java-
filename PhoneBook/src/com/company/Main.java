package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static final MobilePhone Samsung = new MobilePhone("Samsung","S22","01881884697") {};
    public static void main(String[] args) {
         boolean quit =false;
         Samsung.printMessage();
         printActions();
         while(!quit){
             System.out.println("\nEnter Action:  (press 7 to show available actions)");
             int action= scanner.nextInt();
             switch (action){
                 case 0:
                     System.out.println("\nShutting down...");
                     quit=true;
                     break;
                 case 1:
                     addNewContact();
                     break;
                 case 2:
                     printContacts();
                     break;
                 case 3:
                     removeContact();
                     break;
                 case 4:
                     updateContact();
                     break;
                 case 5:
                     queryContact();
                     break;
                 case 6:
                     printBalance();
                     break;
                 case 7:
                     printActions();
                     break;

             }
         }
    }
    private static void addNewContact(){
        System.out.println("Enter New Contact Name:");
        String hudai= scanner.nextLine();
        String name= scanner.nextLine();
        System.out.println("Enter Contact Number:");
        String number= scanner.nextLine();
        Contact newContact = new Contact(name,number);
        if (Samsung.addNewContact(newContact)){
            System.out.println("New Contact Added: Name= " + name + ", Phone= "+ number);
        }else{
            System.out.println("Can't add. Contact already Exists");
        }
    }


    private static void printContacts(){
        Samsung.printContacts();
    }


    private static void removeContact(){
        System.out.println("Enter existing Contact name:");
        String hudai=scanner.nextLine();
        String name= scanner.nextLine();
        Contact existingContact= Samsung.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact Not Found!");
        }else{
            if(Samsung.removeContact(existingContact)){
                System.out.println("Successfully Removed Contact");
            }else{
                System.out.println("Error While Removing Contact");
            }
        }

    }

    private static void updateContact(){
        System.out.println("Enter existing Contact name:");
        String hudai= scanner.nextLine();
        String name= scanner.nextLine();
        Contact existingContact= Samsung.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact Not Found!");
        }else{
            System.out.println("Enter New Contact Name: ");
            String newName= scanner.nextLine();
            System.out.println("Enter new Contact phone Number");
            String newNumber=scanner.nextLine();
            Contact newContact= new Contact(newName,newNumber);
            if(Samsung.updateContact(existingContact,newContact)){
                System.out.println("Successfully Updated Record!");
            }else{
                System.out.println("Error Updating Record");
            }
        }
    }

    private static void queryContact(){
        System.out.println("Enter existing Contact name:");
        String hudai1= scanner.nextLine();
        String name= scanner.nextLine();
        Contact existingContactRecord= Samsung.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact Not Found!");
        }else{
            System.out.println("Contact with Name " + name + " Exists.\n"+
                               "Name: "+ existingContactRecord.getName()+
                               "\nNumber: "+ existingContactRecord.getPhoneNumber());
        }

    }


    private static void printBalance(){
        Samsung.checkBalance();
    }



    private static void printActions(){
        System.out.println("Available Options:\npress");
        System.out.println("0  -  to shutdown\n" +
                           "1  -  to add a new contact\n"  +
                           "2  -  to print all contacts\n"  +
                           "3  -  to remove an existing contact\n" +
                           "4  -  to update an existing contact\n" +
                           "5  -  to query if a contact exists\n"  +
                           "6  -  to check available balance\n"  +
                           "7  -  to print the list of available options.");
    }
}



