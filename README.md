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

# Required Libraries:

PostgreSQL JDBC Driver
Apache Commons Configuration (for working with property files)
Maven will automatically handle downloading and managing these dependencies.

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

CREATE: Add a new person to the database.
VIEW: Retrieve and display a person's information by last name.
q: Terminate app.

# Future Updates

Swing-based GUI: A graphical user interface will be developed to make the application more user-friendly.
Data Fetching Features: Ability to query the database using more criteria (e.g., by email, company, etc.).
Enhanced Functionality: Additional features like exporting data and advanced filtering.
