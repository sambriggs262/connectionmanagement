# Scalable Phonebook

**Scalable Phonebook** is a Java application designed to manage and track professional connections. It allows users to organize contact details, such as recruiters, companies, and peers, while maintaining communication history and follow-up schedules.

---

## 📈 Features

- 📥 Manage professional connections (recruiters, companies, peers).
- ⚙️ Add, update, and view connection information.
- 🗓️ Track communication history and next follow-up dates.
- 📋 Store contact details like email, phone number, and LinkedIn profile.
- 🖥️ CLI-based application with simple interaction.

---

## 🛠️ Tech Stack

- Java 11+
- PostgreSQL
- Maven
- JUnit (for testing)
- JDBC (for database interaction)

---

## 📦 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sambriggs262/ConnectionManagement.git
   cd ConnectionManagement
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Configure your PostgreSQL database by updating `application.properties` with your database credentials.

4. Run the application:
   ```bash
   mvn exec:java
   ```

5. Start managing your connections through the CLI.

---

## 🚀 Usage

The application allows you to interact with your connections through the CLI:

- Add a new connection:
    ```java
    ConnectionManager.addConnection("John Doe", "john.doe@email.com", "Recruiter", "LinkedIn URL");
    ```
- View all connections:
    ```java
    ConnectionManager.viewConnections();
    ```

---

## 📁 Project Structure

```
ConnectionManagement/
├── src/
│   ├── main/java/com/connectionsapp/   # Application logic and database interaction
│   └── resources/                      # Configuration files (application.properties)
├── target/                            # Maven build output
├── pom.xml                            # Maven dependencies and project configuration
├── .gitignore                         # Git exclusions
└── README.md                          # You're here
```

---

## 📜 License

This project is open source and available under the MIT License.

---

## 👤 Author

**Sam Briggs**
[GitHub](https://github.com/sambriggs262) • [LinkedIn](https://linkedin.com/in/sam-briggs-8a825b327)

---

## 💡 Notes

- This application is designed as a personal project to help manage professional connections.
- Consider adding more advanced features like user authentication or a GUI for better usability.
