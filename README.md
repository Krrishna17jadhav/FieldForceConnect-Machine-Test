# FieldForceConnect Machine Test

## Candidate Submission

This repository contains my submission for the Nimap Infotech Machine Test.

## Project Modules

### 1. Selenium Automation

Automated the following scenarios using Java, Selenium WebDriver, Maven and TestNG:

* Login Journey using parameterization
* Login validation
* Add Customer using parameterization
* Add Customer validation

### 2. Manual Testing

The Manual Testing section contains:

* Sign Up test cases
* Forgot Password test cases
* Sign with OTP test cases
* Login test cases
* Field validations
* Bug reports identified during testing

### 3. Postman API Testing

The Postman section contains:

* Environment configuration
* Base URL variable
* Authentication variables
* Login API with valid credentials
* Login API with invalid credentials
* Add Customer API
* GET and POST API testing
* API response validations using Postman scripts

## Technologies Used

* Java
* Selenium WebDriver
* Maven
* TestNG
* Postman
* Git
* GitHub

## Application Under Test

FieldForce Connect

## Project Structure

```text
FieldForceConnect-Machine-Test
│
├── Selenium-Automation
│   ├── pom.xml
│   ├── testng.xml
│   └── src
│
├── Manual-Testing
│   ├── Manual-Test-Cases.xlsx
│   ├── Field-Validation.xlsx
│   └── Bug-Report.xlsx
│
├── Postman
│   └── FieldForceConnect-API-Collection.json
│
└── README.md
```

## Execution

### Selenium

Open the `Selenium-Automation` project in Eclipse/IntelliJ and execute the TestNG test classes or `testng.xml`.

### Postman

Import the collection from the `Postman` folder and configure the required environment variables before execution.

## Note

Sensitive credentials, passwords, authentication tokens and cookies have not been committed to this repository.
