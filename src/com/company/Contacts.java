package com.company;

public class Contacts {
//        2. Implement the Contact class with the following attributes:
//    -  Two fields, both String, one called name and the other phoneNumber.
//    -  A constructor that takes two Strings, and initialises name and phoneNumber.
//    -  And Three methods, they are:
//        -  getName(), getter for name.
//        -  getPhoneNumber(), getter for phoneNumber.
//        -  createContact(), has two parameters of type String (the persons name and phone number) and returns an instance of Contact. This is the only method that is static.

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }

}
