package com.connectionsapp.utils;
import com.connectionsapp.db.DatabaseManager;
import com.connectionsapp.models.Person;
import java.util.Scanner;

public class InputManager {
    private DatabaseManager dbManager;

    public InputManager (String action, DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void handleCreateAction(){
        Scanner creation_scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String first = creation_scanner.nextLine();
        System.out.println("Enter last name: ");
        String last = creation_scanner.nextLine();
        System.out.println("Enter email: ");
        String email = creation_scanner.nextLine();
        System.out.println("Enter prefix(Mr., Ms., etc): ");
        String prefix = creation_scanner.nextLine();
        System.out.println("Enter company: ");
        String company = creation_scanner.nextLine();
        System.out.println("Enter position recruiting for: ");
        String position = creation_scanner.nextLine();

        Person person = new Person(first, last, email, company, prefix, position);
        boolean success = dbManager.insertPerson(person);
        if (success) {
            System.out.println("A new Person was inserted successfully!");
        } else {
            System.out.println("Failed to insert the Person. Please check the database connection.");
        }


    }
    public void handleViewAction() {
        Scanner view_scanner = new Scanner(System.in);
        System.out.println("Enter the last name of the Person: ");
        String lastName = view_scanner.nextLine();

        // Fetch and display result
        String result = dbManager.viewPerson(lastName);
        System.out.println(result);
    }
}




