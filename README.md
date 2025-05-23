# Login Test Automation - Selenium TestNG Framework

This project automates the login functionality of a web application using Selenium WebDriver with Java and TestNG. It verifies login behavior under multiple conditions including valid credentials, incorrect username, and incorrect password. The framework uses PageFactory, Maven, and generates rich ExtentReports with screenshots.

## 📌 Test Scenarios

1. ✅ **Successful Login**
2. ❌ **Invalid Username**
3. ❌ **Invalid Password**

## ✅ Features

- PageFactory pattern for clean and reusable code
- TestNG for test organization and assertions
- ExtentReports with screenshots for all test outcomes
- Configurable browser and credentials
- Organized codebase with modular structure

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- ExtentReports
- Apache POI (if Excel used)
- PageFactory

## 📁 Project Structure

PRACTICE_AUTOMATION_TEST/
├── .vscode/
├── screenshots/ # Stores screenshots for test results
├── src/
│ ├── main/
│ │ └── resources/
│ │ └── config.properties # Test configuration
│ └── test/
│ └── java/
│ ├── baseClass/ # Base test class and WebDriver setup
│ ├── pageObjects/ # PageFactory classes for UI elements
│ ├── testClasses/ # Actual test methods for login
│ └── utilities/ # Reusable utility classes (e.g., for screenshots, reports)
├── target/
├── test_output/ # TestNG and Extent report outputs
├── pom.xml # Maven dependencies and plugins
└── testng.xml # TestNG configuration
