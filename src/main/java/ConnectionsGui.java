import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionsGui{


    public class Person {
        private String first;
        private String last;
        private String email;
        private String company;
        private String prefix;
        private String position;

        public Person(String first, String last, String email, String company, String prefix, String position) {
            this.first = first;
            this.last = last;
            this.email = email;
            this.company = company;
            this.prefix = prefix;
            this.position = position;
        }
        public String getName() {
            return first + last;
        }
        public String getFirst(){
            return first;
        }

        public String getLast() {
            return last;
        }

        public String getEmail(){

            return email;
        }
        public String getCompany(){

            return company;
        }
        public String getPrefix(){

            return prefix;
        }

        public String getPosition() {
            return position;
        }
        public String toString(){
            return prefix + " " + first + " " + last + ", recruiting for " + position + " at " + company + " (Email: " + email + ")";
            }
        public String emailFormat(){
            return "Dear " + prefix + "";
        }
    }

    public static Properties loadConfig(){
        Properties props = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("config/properties.config")) {
            props.load(fileInputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return props;

    }

    public static void main(String[] args) {
        Properties config = loadConfig();
        String url = config.getProperty("db.url");
        String user = config.getProperty("db.user");
        String password = config.getProperty("db.password");

        Scanner action_scanner = new Scanner(System.in);
        String action = "";


    while(!action.equalsIgnoreCase("q")) {
        System.out.println("Enter an action: CREATE or VIEW, or q to quit");
        action = action_scanner.nextLine();


        if (Objects.equals(action, "CREATE")) {
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

            ConnectionsGui connectionsGui = new ConnectionsGui();

            Person person = connectionsGui.new Person(first, last, email, company, prefix, position);


            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO Persons (first_name, last_name, email, company, prefix, position_recruiting) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, first);
                preparedStatement.setString(2, last);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, company);
                preparedStatement.setString(5, prefix);
                preparedStatement.setString(6, position);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new person was inserted successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(action, "VIEW")) {
            Scanner view_scanner = new Scanner(System.in);
            System.out.println("Enter the last name of a person: ");

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String view_last = view_scanner.nextLine();
                String view_sql = "SELECT * FROM persons WHERE last_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(view_sql);
                preparedStatement.setString(1, view_last);

                ResultSet resultSet = preparedStatement.executeQuery();

                boolean found = false;

                while (resultSet.next()) {
                    found = true;
                    String first = resultSet.getString("first_name");
                    String last = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String company = resultSet.getString("company");
                    String prefix = resultSet.getString("prefix");
                    String position = resultSet.getString("position_recruiting");

                    Person person = new ConnectionsGui().new Person(first, last, email, company, prefix, position);
                    System.out.println(person);
                }
                if (!found) {
                    System.out.println("No person found with last name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }




        }

    else if(!action.equalsIgnoreCase("q")){
        System.out.print("Invalid action. Please enter CREATE, VIEW, or q to quit");
        }



    }
    action_scanner.close();
}}