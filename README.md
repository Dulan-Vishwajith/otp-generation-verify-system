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
