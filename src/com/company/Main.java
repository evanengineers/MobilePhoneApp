package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Contacts> myContacts = new ArrayList<>();
    private static MobilePhone mobilePhone = new MobilePhone(myContacts, "2059999999");

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact.");
        System.out.println("\t 3 - To modify a contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To quit the application.");
    }
//        TIP:  In MobilePhone, use findContact() in the other methods (except printContacts()) to check if it exists before proceeding.
//        TIP:  Two Contact objects are equal if they have the same name.
//        TIP:  Be extremely careful about spaces in the printed message.
//        NOTE:  If you get an error from the Evaluate class, it's most likely the constructor. Check if you've added a constructor or if the constructor has the right arguments.

    private static void addContact() {
        System.out.println("Enter the contact name.\r");
        String name = scanner.nextLine();
        System.out.println("Enter " + name + "'s contact number.");
        String number = scanner.nextLine();
        //Contacts newContact = Contacts.createContact(name, number); //Can use "Contacts....." because its static and being used as a convenience method.
        mobilePhone.addNewContact(Contacts.createContact(name, number));
    }

    private static void modifyContact() {
        System.out.println("Enter a contact name which you want to modify.");
        String contactToBeModified = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContacts(contactToBeModified);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter replacement contact.");
        String replacement = scanner.nextLine();
        System.out.println("Enter new contact number.");
        String newNumber = scanner.nextLine();
        mobilePhone.updateContact(existingContact, new Contacts(replacement, newNumber));
    }

    private static void removeContact() {
        System.out.println("Enter a contact name which you want to remove.");
        String contactToBeRemoved = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContacts(contactToBeRemoved);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        mobilePhone.removeContact(existingContact);
    }

    private static void searchForContact() {
        System.out.println("Enter a contact to search.");
        String contactToBeSearched = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContacts(contactToBeSearched);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Contact found.");
        System.out.println(existingContact.getName() + " -> " + existingContact.getPhoneNumber());
    }
}
