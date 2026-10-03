# Web UI & API Automation Testing

Automation testing framework menggunakan Java untuk melakukan pengujian **Web UI** dan **REST API** dengan pendekatan BDD menggunakan Cucumber.

Project ini dibuat menggunakan Selenium WebDriver untuk Web UI Automation dan REST Assured untuk API Automation, dengan JUnit 5 sebagai test engine serta Allure Report untuk test reporting.

## 🛠️ Technology Stack

- Java 25
- Gradle 9.2.0
- Selenium WebDriver 4.25.0
- Cucumber 7.18.1
- JUnit 5.11.0
- REST Assured 5.5.0
- Allure Report
- Google Chrome
- IntelliJ IDEA

## 🧪 Test Coverage

### Web UI Automation

Pengujian login pada aplikasi web menggunakan Selenium WebDriver.

Scenarios:

- Login dengan username dan password yang benar
- Login dengan username dan password yang salah
- Login dengan username kosong
- Login dengan username sangat panjang

**Total: 4 Web UI scenarios**

### API Automation

Pengujian Authentication API menggunakan REST Assured.

Scenarios:

- Register kemudian login menggunakan akun baru
- Register kemudian login dan logout menggunakan akun baru
- Login menggunakan password yang salah

**Total: 3 API scenarios**

### 📊 Test Result
Total automated test: 
**7 scenarios**

- 7 Passed
- 0 Failed
- 0 Broken
- 0 Skipped

### ▶️ How to Run Tests

**Run Web UI Tests**
```bash
./gradlew webTest
```
**Run API Tests**
```bash
./gradlew apiTest
```
**Run Web UI & API Tests**
```bash
./gradlew automationTest
```
**Run All Tests with Clean Build**
```bash
./gradlew clean automationTest --rerun-tasks --console=plain
```
### 📈 Allure Report
Generate Allure Report:
```bash
./gradlew allureReport
```
Open Allure Report:
```bash
./gradlew allureServe
```
The Allure report contains:
- API Automation
- Authentication
- Login User
- Test status
- Test duration
- Test steps
- Cucumber scenarios
- Test execution details

### 📋 API Test Scenarios
**Register → Login**

Validates that a newly registered user can successfully log in.
Expected result:

- Register → HTTP 201
- Login → HTTP 200
- `success` → `true`

**Register → Login → Logout**

Validates the complete authentication flow.
Expected result:

- Register → HTTP 201
- Login → HTTP 200
- Logout → HTTP 200

### Login with Wrong Password

Validates that the API rejects invalid credentials.

Expected result:

- HTTP 401
- 
  `success` → `false`

### 🧩 Framework Design

The framework follows a separation of concerns between:

- **Feature Files** — contain business scenarios using Gherkin
- **Step Definitions** — implement Cucumber steps
- **Page Objects** — contain Web UI elements and actions
- **API Request Classes** — handle REST API requests
- **Test Runners** — execute Web UI and API test suites
- **Allure** — provides test execution reporting

### 🎯 Purpose

This project demonstrates practical QA Automation skills including:

- Web UI Automation
- API Automation
- BDD with Cucumber
- Page Object Model
- REST API validation
- Positive & Negative Testing
- HTTP Status Code Validation
- Response Payload Validation
- Test Reporting with Allure
- Gradle Test Automation
- Automated test execution
### 👩‍💻 Author
**Upi Resti Wahyuni**




