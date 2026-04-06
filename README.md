# 📱 OTP Service API (Spring Boot + SMS Integration)

## 🚀 Overview

This project is a **Spring Boot backend application** that implements a complete **OTP (One-Time Password) system** with real-world features such as SMS delivery, expiration handling, and database persistence.

It demonstrates a full backend workflow from **API design → business logic → external integration → database storage**.

---

## 🧩 Features

* ✅ Generate OTP
* ✅ Send OTP via SMS (Text.lk)
* ✅ Verify OTP
* ✅ OTP expiration (2 minutes)
* ✅ Store OTP in MySQL database
* ✅ Clean layered architecture
* ✅ DTO-based request handling
* ✅ Simple frontend integration (HTML + JS)

---

## 🏗️ Tech Stack

* **Backend:** Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **SMS Gateway:** Text.lk API
* **Frontend (Basic):** HTML + JavaScript (Fetch API)

---

## 🌿 Branching Strategy

This project follows a **feature-based branching strategy with descriptive naming**.

### 🔹 Branches

* **main**
  Base stable version

* **dto/use_dto**
  Introduces DTO pattern using `@RequestBody`

* **external_API/to_send_SMS**
  Integrates SMS sending via Text.lk API

* **use_database/instead_hashmap**
  Replaces in-memory storage with MySQL database

---

### 🔄 Development Flow

```text
main
 ├── dto/use_dto
 ├── external_API/to_send_SMS
 └── use_database/instead_hashmap
```

Each branch represents a **progressive enhancement of the system**.

---

## 📂 Project Structure

```
src/main/java/com/dulan/otp/

├── controller/
├── service/
├── repository/
├── entity/
├── dto/
└── model/ (legacy - optional)
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/otp-service.git
cd otp-service
```

---

### 2️⃣ Setup Database

```sql
CREATE DATABASE otp_db;
```

---

### 3️⃣ Configure Application

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/otp_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4️⃣ Add SMS API Token

```java
String apiToken = "YOUR_TEXTLK_API_TOKEN";
```

---

### 5️⃣ Run Application

```bash
mvn spring-boot:run
```

---

## 📡 API Endpoints

### 🔹 Generate OTP

**POST** `/otp/generate`

```json
{
  "phoneNumber": "947XXXXXXXX"
}
```

---

### 🔹 Verify OTP

**POST** `/otp/verify`

```json
{
  "phoneNumber": "947XXXXXXXX",
  "otp": 123456
}
```

---

### 📌 Responses

```
OTP verified successfully ✅
Invalid OTP ❌
OTP expired ⏱️
```

---

## 📩 SMS Integration

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

Basic frontend uses:

```javascript
fetch()
```

Flow:

```
User Input → JS → API → Response → UI
```

---

## 🔄 System Flow

```
User → Frontend
     ↓
Fetch API (POST)
     ↓
Controller
     ↓
Service (OTP Logic)
     ↓
Repository
     ↓
MySQL Database
     ↓
SMS API (Text.lk)
     ↓
Response → Frontend
```

---

## 📄 File-by-File Explanation

### 📁 OtpController.java

Handles HTTP requests and routes them to the service layer.

---

### 📁 OtpService.java

Core logic:

* Generate OTP
* Store OTP
* Send SMS
* Verify OTP
* Handle expiration

---

### 📁 OtpRepository.java

Handles database operations using JPA.

---

### 📁 OtpEntity.java

Represents database table structure.

---

### 📁 DTOs

* `GenerateOtpRequest`
* `VerifyOtpRequest`

Used to transfer request data cleanly.

---

### 📁 application.properties

Stores configuration (DB, JPA, etc.)

---

### 📁 Frontend Files

* `index.html`
* `script.js`

Handles user interaction and API calls.

---

## 🧠 Architecture

```
Controller → Service → Repository → Database
        ↓
      DTO Layer
        ↓
   External API (SMS)
```

---

## ⚠️ Important Notes

* Phone format: `947XXXXXXXX`
* OTP expires in **2 minutes**
* OTP is deleted after verification

---

## 🚀 Future Improvements

* 🔐 JWT Authentication
* ⏳ Rate Limiting
* ⚡ Redis for OTP storage
* 🎨 React frontend
* ☁️ Cloud deployment

---

## 👨‍💻 Author

**Dulan Vishwajith**
Software Engineering Student

---

## ⭐ Support

If you found this useful, consider giving it a ⭐ on GitHub 🚀
