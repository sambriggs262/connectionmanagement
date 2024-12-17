# Connection Management App

This is a Java-based connection management app that allows users to manage, create, and view information about various persons in the database, such as recruiters and companies. It uses JDBC to interact with a PostgreSQL database.

# Features

Add new persons with attributes like name, email, company, and position.
View records based on specific criteria, such as last name.
Interaction via a command-line interface.
Dependencies/Requirements

This project uses Maven to manage dependencies. You can easily set it up by following the steps below:

Ensure Maven is installed on your system.
Place the pom.xml file in your project root.
Run the following command to download and set up all dependencies:
mvn clean install

# Required Libraries/Installations:

PostgreSQL

PGSQL JDBC Driver

Apache Commons Configuration (for working with property files)

Maven will automatically handle downloading and managing these dependencies.

PGAdmin 4 - not required, but highly recommended for troubleshooting.

# Installation

Clone this repository:
git clone https://github.com/sambriggs262/connectionmanagement.git

Navigate to the project directory:
cd connectionmanagement

Configure the database settings in the config/properties.config file.
Build the project with Maven:
mvn clean install

# Usage

To run the app, use the following command:

java -jar target/connectionmanagement-1.0-SNAPSHOT.jar

Once the app is running, you can interact with it using the following commands:

CREATE: Add a new Person to the database.
VIEW: Retrieve and display a Person's information by last name.
q: Terminate app.

# Update 12/17/2024 (v1.0.1)
- User-Friendly GUI: Added a Swing-based graphical user interface (GUI) for improved usability and intuitive navigation.

- Improved Project Structure: Refactored and organized the file structure to follow industry best practices.

- File Packaging: Packaged files to maintain clarity and modularity.

- Cloud Integration: Migrated the backend PostgreSQL database to AWS RDS for scalability and accessibility.

# Future Updates
- Transition from proof-of-concept to production-ready application.
- Enhanced, production-ready GUI: Clean, minimalist GUI, possibly with JavaFX.
- Implement secure user data storage and retrieval using AWS RDS.
- Scalability Enhancements: Optimize database performance for handling multiple users concurrently.
- Security: Enforce robust security measures, including encryption of sensitive data and secure database connections.
- Deployment: Explore deploying the application for real-world use, ensuring AWS infrastructure is configured for reliability and cost efficiency.