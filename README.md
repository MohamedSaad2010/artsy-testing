# QA Testing Project – ArtsySilver E-commerce Website

This repository contains a full Quality Assurance Testing project for the **ArtsySilver** website. The project includes:

- ✅ Manual Testing (Test Cases, Bug Reports, Test Plans)
- 🤖 Automation Testing using Java + Selenium + TestNG
- 🔌 API Testing using Postman (to be added)
- 🚀 Performance Testing using JMeter (coming soon)
---
## 📁 Project Structure
--
## ✅ Manual Testing

- File: `manual/artsysilver.xlsx`
- Contains:
  - Test case scenarios for user journey
  - Bug report samples
  - Functional checklist

Tools used: **Excel**, **Google Sheets**

---

## 🤖 Automation Testing (Java + Selenium)

The automation tests simulate user actions on the [https://artsysilver.co/](https://artsysilver.co/) website.

### 🔹 Tools Used

## 📦 Requirements

- Java 17+ (Project tested on JDK 24)
- Chrome Browser
- Selenium & WebDriverManager JARs
- Maven & TestNG
- (Optional) Node.js + Newman for API


### 🔹 Example Test Scenarios

- `BuyItNow.java` – Tests instant purchase flow
- `CartTest.java` – Tests adding/removing items in cart
- `DeliveryPassTest.java` – Tests delivery options
- `LogIn.java` – Tests login form
- `SearchForAnItem.java`, `pass_search.java`, `Fail_Search_saad.java` – Search functionality

### 🔹 How to Run

``bash
# Compile and run a test
javac -cp ".;path/to/selenium-java.jar;path/to/webdrivermanager.jar" BuyItNow.java
java BuyItNow`

## 📑 Test Planning & Strategy

This project includes full QA documentation:

- 📄 [Test Plan](qa-testing-project/test-strategy/test-plan.md)
- 📄 [Test Strategy](qa-testing-project/test-strategy/test-strategy.md)

  
