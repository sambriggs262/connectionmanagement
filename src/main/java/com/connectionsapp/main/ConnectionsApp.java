package com.connectionsapp.main;
import java.util.Properties;
import java.util.Scanner;
import com.connectionsapp.utils.InputManager;
import com.connectionsapp.db.DatabaseManager;
import com.connectionsapp.utils.PropertiesManager;

public class ConnectionsApp {
    public static void main(String[] args) {
        Properties config = PropertiesManager.loadConfig();
        String url = config.getProperty("db.url");
        String user = config.getProperty("db.user");
        String password = config.getProperty("db.password");

        DatabaseManager dbManager = new DatabaseManager(url, user, password);

        Scanner scanner = new Scanner(System.in);
        String action = "";

        while (!action.equalsIgnoreCase("q")) {
            System.out.println("Enter an action: CREATE or VIEW, or q to quit");
            action = scanner.nextLine();

            InputManager inputManager = new InputManager(action, dbManager);

            if (action.equalsIgnoreCase("CREATE")) {
                inputManager.handleCreateAction();
            } else if (action.equalsIgnoreCase("VIEW")) {
                inputManager.handleViewAction();
            } else if (!action.equalsIgnoreCase("q")) {
                System.out.println("Invalid action. Please enter CREATE, VIEW, or q to quit");
            }
        }
        scanner.close();
    }
}
