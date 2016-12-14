package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("777 771 7127");

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action: (6 - to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + " - " + phone);
        } else {
            System.out.println("Cannot add, " + name + " is already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact was not found");
            return;
        } else {
            System.out.println("Enter new contact name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new contact phone number:");
            String newNumber = scanner.nextLine();
            Contact newContact = Contact.createContact(newName, newNumber);
            if (mobilePhone.updateContact(existingContactRecord, newContact)) {
                System.out.println("Success!   :D");
            } else {
                System.out.println("Error");
            }
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact was not found");
            return;
        } else {
            if (mobilePhone.removeContact(existingContactRecord)) {
                System.out.println("Removed");
            } else {
                System.out.println("Error");
            }
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact was not found");
            return;
        } else {
            System.out.println("Name: " + existingContactRecord.getName() + ", phone: " + existingContactRecord.getPhoneNumber());
        }
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shut down");
        System.out.println("1 - to print contacts");
        System.out.println("2 - to add a new contact");
        System.out.println("3 - update an existing contact");
        System.out.println("4 - to remove an existing contact");
        System.out.println("5 - query if a contact exists");
        System.out.println("6 - to print a list of available actions.");
        System.out.println("Choose your action:");
    }
}
