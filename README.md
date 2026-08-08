# Web UI Automation Testing

Automation testing framework untuk pengujian Web UI menggunakan Java, Gradle, Selenium WebDriver, Cucumber, dan JUnit.

## 🛠️ Technology Stack

- Java 25
- Gradle
- Selenium WebDriver
- Cucumber
- JUnit 5
- Google Chrome

## 📂 Project Structure

```text
WebUIAutomation
│
├── build.gradle
├── settings.gradle
├── README.md
│
└── src
    └── test
        ├── java
        │   └── org.upiresti
        │       ├── LoginPage.java
        │       ├── LoginStep.java
        │       └── TestRunner.java
        │
        └── resources
            └── features
                └── login.feature

Gherkin Feature
      ↓
Step Definition
      ↓
Page Object
      ↓
Selenium WebDriver
      ↓
Web Browser