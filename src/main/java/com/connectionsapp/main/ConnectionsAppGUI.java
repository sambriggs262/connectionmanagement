package com.connectionsapp.main;

import com.connectionsapp.db.DatabaseManager;
import com.connectionsapp.models.Person;
import com.connectionsapp.utils.PropertiesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionsAppGUI {
    public static void main(String[] args) {
        PropertiesManager propertiesManager = new PropertiesManager();
        String url = propertiesManager.loadConfig().getProperty("db.url");
        String user = propertiesManager.loadConfig().getProperty("db.user");
        String password = propertiesManager.loadConfig().getProperty("db.password");
        DatabaseManager dbManager = new DatabaseManager(url, user, password);

        JFrame frame = new JFrame("Connections App");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        String[] actions = {"Create", "View"};
        JComboBox<String> createOrView = new JComboBox<>(actions);
        panel.add(new JLabel("Select Action"));
        panel.add(createOrView);

        JButton submitter = new JButton("Submit");
        panel.add(submitter);

        submitter.addActionListener(e -> {
            String selected = (String) createOrView.getSelectedItem();

            if (selected.equals("Create")) {
                panel.removeAll();
                panel.setLayout(new GridLayout(0, 2));

                JTextField firstNameField = new JTextField();
                JTextField lastNameField = new JTextField();
                JTextField emailField = new JTextField();
                JTextField companyField = new JTextField();
                JTextField prefixField = new JTextField();
                JTextField positionField = new JTextField();

                panel.add(new JLabel("First Name:"));
                panel.add(firstNameField);
                panel.add(new JLabel("Last Name:"));
                panel.add(lastNameField);
                panel.add(new JLabel("Email:"));
                panel.add(emailField);
                panel.add(new JLabel("Company:"));
                panel.add(companyField);
                panel.add(new JLabel("Prefix (Mr./Mrs.):"));
                panel.add(prefixField);
                panel.add(new JLabel("Position Recruiting For:"));
                panel.add(positionField);

                JButton createButton = new JButton("Create Person");
                JButton homeButton = new JButton("Home");
                panel.add(createButton);
                panel.add(homeButton);

                panel.revalidate();
                panel.repaint();

                createButton.addActionListener(event -> {
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String email = emailField.getText();
                    String company = companyField.getText();
                    String prefix = prefixField.getText();
                    String position = positionField.getText();

                    Person newPerson = new Person(firstName, lastName, email, company, prefix, position);
                    boolean success = dbManager.insertPerson(newPerson);

                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Person successfully created!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error creating person", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

                homeButton.addActionListener(homeEvent -> {
                    resetToHome(panel, createOrView, submitter);
                });
            }

            if (selected.equals("View")) {
                panel.removeAll();
                panel.setLayout(new GridLayout(0, 2));

                JTextField searchLastField = new JTextField();
                panel.add(new JLabel("Search by last name:"));
                panel.add(searchLastField);

                JButton searchButton = new JButton("Search");
                JButton homeButton = new JButton("Home");
                panel.add(searchButton);
                panel.add(homeButton);

                panel.revalidate();
                panel.repaint();

                searchButton.addActionListener(event -> {
                    String lastName = searchLastField.getText();
                    String result = dbManager.viewPerson(lastName);
                    JOptionPane.showMessageDialog(frame, result);
                });

                homeButton.addActionListener(homeEvent -> {
                    resetToHome(panel, createOrView, submitter);
                });
            }
        });

        frame.setVisible(true);
    }

    private static void resetToHome(JPanel panel, JComboBox<String> createOrView, JButton submitter) {
        panel.removeAll();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Select Action"));
        panel.add(createOrView);
        panel.add(submitter);
        panel.revalidate();
        panel.repaint();
    }
}
