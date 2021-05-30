package com.company;

import java.util.ArrayList;

public class MobilePhone {
    //        1.  Implement the master class MobilePhone, that holds the ArrayList of Contacts, with the following attributes:
//    -  Two fields, a String called myNumber and an ArrayList of type Contact called myContacts.
    private ArrayList<Contacts> myContacts;
    private String myNumber;

    public ArrayList<Contacts> getMyContacts() {
        return myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    //A constructor that takes a String (the phone number) and initialises myNumber and instantiates myContacts.
    public MobilePhone(ArrayList<Contacts> myContacts, String myNumber) {
        this.myContacts = new ArrayList<Contacts>();
        this.myNumber = myNumber;
    }

    //  addNewContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact doesn't exists, or false if the contact already exists.
    public boolean addNewContact(Contacts contact) {
        int exists = findContact(contact);
        if (exists >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(contact);
        System.out.println("New Contact added.");
        return true;
    }

    //updateContact(), has two parameters of type Contact (the old contact that will be updated with the new contact) and returns a boolean.
    // Returns true if the contact exists and was updated successfully, or false if the contact doesn't exists.
    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int indexOFOldContact = findContact(oldContact);
        if (indexOFOldContact >= 0) {
            myContacts.set(indexOFOldContact, newContact);
            System.out.println("Contact replaced.");
            return true;
        }
        System.out.println("Old contact doesn't exist.");
        return false;
    }

    //        -  removeContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact exists and was removed successfully, or false if the contact doesn't exists.
    public boolean removeContact(Contacts contact) {
        int indexOfContactToBeRemoved = findContact(contact);

        if (indexOfContactToBeRemoved >= 0) {
            myContacts.remove(contact);
            System.out.println("Contact removed.");
            return true;
        }
        System.out.println("Contact not found.");
        return false;

    }

    //  findContact(), has one parameter of type Contact and returns an int. The returned value is it's position in the ArrayList, it will either be -1 (doesn't exists) or a value greater than or equal to 0 (does exists).
    public int findContact(Contacts contact) {
        return myContacts.indexOf(contact);

    }

    //findContact(), same as above, only it has one parameter of type String.
    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (contactName == getMyContacts().get(i).getName()) {
                return i;
            }
        }
        return -1;
    }

    //queryContact(), has one parameter of type String and returns a Contact. Use the String to search for the name and then return the Contact. Return null otherwise.
    public Contacts queryContact(String name) {
        int existingContact = findContact(name);
        if (existingContact >= 0) {
            return getMyContacts().get(existingContact);
        }
        return null;
    }

//     -  printContacts(), has no parameters and doesn't return anything. Print the contacts in the following format:
//        Contact List:
//        1. Bob -> 31415926
//        2. Alice -> 16180339
//        3. Tom -> 11235813
//        4. Jane -> 23571113

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(((i + 1) + ". " + getMyContacts().get(i).getName()) + " -> " +
                    getMyContacts().get(i).getPhoneNumber());
        }
    }
}
