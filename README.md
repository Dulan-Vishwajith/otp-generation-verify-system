# 📱 OTP Service API (Spring Boot + SMS Integration)

## 🚀 Overview

This project is a **Spring Boot backend application** that provides a complete **OTP (One-Time Password) system** with:

* OTP generation
* OTP verification
* SMS sending via Text.lk API
* Expiration handling
* Database storage using MySQL

👉 This project demonstrates a **real-world backend system** with full API flow.

---

## 🧩 Features

* ✅ Generate OTP
* ✅ Send OTP via SMS
* ✅ Verify OTP
* ✅ OTP expiration (2 minutes)
* ✅ Store OTP in MySQL database
* ✅ Clean architecture (Controller → Service → Repository)
* ✅ DTO-based request handling
* ✅ Frontend integration (HTML + JavaScript)

---

## 🏗️ Tech Stack

* **Backend:** Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **SMS Gateway:** Text.lk API
* **Frontend (Basic):** HTML, JavaScript (Fetch API)

---

## 📂 Project Structure

```
src/main/java/com/dulan/otp/

├── controller/
│   └── OtpController.java
│
├── service/
│   └── OtpService.java
│
├── repository/
│   └── OtpRepository.java
│
├── entity/
│   └── OtpEntity.java
│
├── dto/
│   ├── GenerateOtpRequest.java
│   └── VerifyOtpRequest.java
│
└── model/ (optional for earlier step)
    └── OtpData.java
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Project

```
git clone https://github.com/your-username/otp-service.git
cd otp-service
```

---

### 2️⃣ Configure MySQL

Create database:

```
CREATE DATABASE otp_db;
```

---

### 3️⃣ Update `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/otp_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4️⃣ Add SMS API Token

Inside `OtpService.java`:

```
String apiToken = "YOUR_TEXTLK_API_TOKEN";
```

---

### 5️⃣ Run Application

```
mvn spring-boot:run
```

---

## 📡 API Endpoints

### 🔹 Generate OTP

**POST** `/otp/generate`

Request Body:

```json
{
  "phoneNumber": "947XXXXXXXX"
}
```

Response:

```
OTP sent successfully
```

---

### 🔹 Verify OTP

**POST** `/otp/verify`

Request Body:

```json
{
  "phoneNumber": "947XXXXXXXX",
  "otp": 123456
}
```

Response:

```
OTP verified successfully ✅
```

OR

```
Invalid OTP ❌
```

OR

```
OTP expired ⏱️
```

---

## 📩 SMS Integration

* Uses **Text.lk SMS Gateway**
* Endpoint:

```
https://app.text.lk/api/http/sms/send
```

* Required parameters:

  * `api_token`
  * `recipient`
  * `sender_id`
  * `type=plain`
  * `message`

---

## 🌐 Frontend Usage

Simple HTML + JavaScript is used to:

* Enter phone number
* Request OTP
* Enter OTP
* Verify OTP

Uses:

```
fetch() API
```

to communicate with backend.

---

## 🔄 Flow Diagram

```
User → Frontend (HTML/JS)
     ↓
Fetch API (POST request)
     ↓
Spring Boot Controller
     ↓
Service Layer (OTP logic)
     ↓
Database (MySQL)
     ↓
SMS API (Text.lk)
     ↓
Response → Frontend
```

---

## 🧠 Key Concepts Learned

* REST API development
* DTO pattern (`@RequestBody`)
* Service layer architecture
* JPA & database persistence
* External API integration
* CORS handling
* Frontend-backend communication

---

## ⚠️ Important Notes

* Phone number must be in format:

```
947XXXXXXXX
```

* OTP expires after **2 minutes**
* OTP is deleted after successful verification

---
## 📄 File-by-File Explanation

This section explains the purpose of each file in the project.

---

### 📁 controller/OtpController.java

👉 **Handles incoming HTTP requests**

* Defines API endpoints:

  * `POST /otp/generate`
  * `POST /otp/verify`
* Receives request data using DTO (`@RequestBody`)
* Calls service layer to process logic

💡 Think of this as:

> “The entry point of the backend”

---

### 📁 service/OtpService.java

👉 **Contains business logic**

Responsibilities:

* Generate OTP (6-digit random number)
* Store OTP in database
* Set expiration time (2 minutes)
* Send OTP via SMS (Text.lk API)
* Verify OTP (check correctness + expiry)
* Delete OTP after verification

💡 Think of this as:

> “The brain of the application”

---

### 📁 repository/OtpRepository.java

👉 **Handles database operations**

* Extends `JpaRepository`
* Provides built-in methods:

  * `save()`
  * `delete()`
  * `findById()`
* Custom method:

  * `findByPhoneNumber(String phoneNumber)`

💡 Think of this as:

> “The communication layer with the database”

---

### 📁 entity/OtpEntity.java

👉 **Represents database table**

Fields:

* `id` → Primary key
* `phoneNumber` → User phone number
* `otp` → Generated OTP
* `expiryTime` → Expiration timestamp

💡 Automatically mapped to a MySQL table by JPA

💡 Think of this as:

> “The structure of stored data”

---

### 📁 dto/GenerateOtpRequest.java

👉 **DTO for OTP generation request**

* Contains:

  * `phoneNumber`

Used in:

```id="dto1"
POST /otp/generate
```

💡 Converts incoming JSON → Java object

---

### 📁 dto/VerifyOtpRequest.java

👉 **DTO for OTP verification**

* Contains:

  * `phoneNumber`
  * `otp`

Used in:

```id="dto2"
POST /otp/verify
```

💡 Keeps API clean and structured

---

### 📁 model/OtpData.java *(Optional / earlier step)*

👉 Used when OTP was stored in memory (HashMap)

* Contains:

  * OTP
  * Expiry time

⚠️ Not needed after database integration

---

### 📁 application.properties

👉 **Configuration file**

Contains:

* Database connection (MySQL)
* JPA settings
* Hibernate behavior

Example:

```id="cfg1"
spring.datasource.url=jdbc:mysql://localhost:3306/otp_db
spring.jpa.hibernate.ddl-auto=update
```

💡 Think of this as:

> “Project settings and configuration”

---

### 📁 Frontend (index.html + script.js)

👉 Simple UI to test backend

* `index.html`

  * Input fields for phone & OTP
  * Buttons for actions

* `script.js`

  * Uses `fetch()` to call backend APIs
  * Sends JSON requests
  * Displays responses

💡 Think of this as:

> “User interface interacting with backend”

---

## 🧠 Overall Architecture

```id="arch1"
Controller → Service → Repository → Database
        ↓
     DTO Layer
        ↓
   External API (SMS)
```

---

## 🎯 Summary

Each layer has a clear responsibility:

* **Controller** → Handles requests
* **Service** → Processes logic
* **Repository** → Talks to DB
* **Entity** → Defines data
* **DTO** → Transfers data
* **Frontend** → Interacts with user

👉 This structure follows **clean architecture principles**

---

## 🚀 Future Improvements

* 🔐 Add authentication (JWT)
* ⏳ Rate limiting (prevent spam)
* ⚡ Use Redis for OTP storage
* 🎨 Build React frontend
* ☁️ Deploy to cloud (AWS / Render)

---

## 👨‍💻 Author

**Dulan Vishwajith**
Software Engineering Student

---

## ⭐ If you like this project

Give it a ⭐ on GitHub and share it 🚀
