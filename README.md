# 📦 ZeptoIMS

The **ZeptoIMS** is a full-stack web application built with **Spring Boot, Java, MySQL, JSP, and Apache Kafka**.

It enables organizations to manage:
- Products & inventory
- Users & roles
- Orders & payments
- Delivery lifecycle

---

## 🏗️ Architecture
Follows **Spring Boot MVC architecture**:

Controller → Service → Repository → Database

### Layers:
- **Controller** – Handles requests & APIs  
- **Service** – Business logic  
- **Repository** – Database operations (JPA)  
- **Model** – Entities (Product, User, Order, etc.)  
- **View (JSP)** – Admin UI  

---

## 🔐 User Roles
- **Admin** – Full access to all modules  
- **Staff** – Limited operational access  

---

## 🧰 Modules
- **Product** – Manage products & stock  
- **User** – User management & roles  
- **Cart** – Temporary order storage  
- **Order** – Order creation & tracking  
- **Payment** – Payment handling  
- **Delivery** – Status tracking  

Scheduled → Out for Delivery → Delivered

---

## 📢 Kafka Integration
- Used for **real-time price drop notifications**

**Flow:**
1. Admin updates product price  
2. Kafka producer sends event  
3. Consumers receive updates  

**Benefits:**
- Real-time updates  
- Scalable 
- Loose coupling  

---

## 🖥️ Frontend (JSP)
Key pages:
- `dashboard.jsp` – Overview  
- `add.jsp` – Add product  
- `addUser.jsp` – Add user  
- `editProduct.jsp` – Edit product  

---

## ⚙️ Configuration
Defined in `application.properties`:
- MySQL connection  
- JSP view resolver  
- Kafka setup  
- Hibernate settings  

---

## 🧩 Key Features
- Real-time notifications (Kafka)  
- RESTful APIs  
- Role-based access control  
- Delivery lifecycle tracking  
- Clean layered architecture  
- MySQL with Hibernate 

---

