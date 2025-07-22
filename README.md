# Online Bookstore

A full-stack web application for browsing, purchasing, and managing books online. The project is split into a backend (Java Spring Boot) and frontend (React with Redux), and includes features such as authentication, search, order processing, and administrative book management.

## 🌐 Live Demo

Hosted via **Azure Static Web Apps** (Frontend) and **Azure Container Apps** (Backend).

Frontend: [Online Bookstore Website](https://ambitious-smoke-0c77b2d10.1.azurestaticapps.net)

---

## 🧰 Tech Stack

### Frontend

- React
- Redux Toolkit (for state management)
- React Router
- Firebase Authentication
- Tailwind CSS
- Axios (for API communication)

### Backend

- Java 17
- Spring Boot
- Spring Web
- Spring Security (with CORS config)
- Spring Data MongoDB
- JWT for secure authentication
- Firebase Admin SDK

### DevOps / Deployment

- Docker
- Azure Container Registry
- Azure Container Apps (for Spring Boot container)
- Azure Static Web Apps (for frontend)
- GitHub Actions CI/CD

---

## 🔐 Features

### User Features

- 🔐 **Login/Register** with Firebase Authentication
- 🔎 **Browse and search books** by keyword
- 📖 **View detailed book info** including price and availability
- 🛒 **Shopping cart**
  - Add books to cart
  - Update quantity
  - Remove from cart
  - Quantity restrictions enforced
- 📦 **Place orders**
  - Checkout flow
  - Order summary page
  - Store order history per user (MongoDB)

### Admin Features

- 🔧 **Admin dashboard** for managing books
  - Add new books
  - Edit existing book information
  - Delete books
- 🛡️ Role-based access: only admins can manage book inventory

---

## 🗄️ Database

- MongoDB (hosted on Azure or MongoDB Atlas)
- Collections:
  - `books`
  - `orders`
  - `users` (mapped to Firebase UID)

---

## 📁 Project Structure

### Backend

```
backend/
├── src/main/java/com/example/bookstore
│   ├── config/
│   ├── controller/
│   ├── dto/
│   ├── model/
│   ├── repository/
│   ├── security/
│   └── service/
├── Dockerfile
└── build.gradle
```

### Frontend

```
frontend/
├── src/
│   ├── app/             # Redux store setup
│   ├── components/      # Shared UI components
│   ├── features/        # Slices for Redux
│   ├── pages/           # Pages like Home, BookDetail, Cart
│   ├── services/        # API and Firebase utils
│   └── App.js
├── tailwind.config.js
└── package.json
```

---

## 🚀 Deployment

### Frontend

- Build: `npm run build`
- Deploy: Pushed to GitHub, triggers Azure Static Web Apps CI/CD

### Backend

- Build JAR: `./gradlew build`
- Docker build: `docker build -t bookstore .`
- Push to ACR: `az acr login`, then `docker push`
- Deploy container to Azure Container Apps

---

## 🔧 Environment Variables

### Frontend

- `REACT_APP_FIREBASE_API_KEY`
- `REACT_APP_FIREBASE_AUTH_DOMAIN`
- `REACT_APP_FIREBASE_PROJECT_ID`
- `REACT_APP_BACKEND_URL`

### Backend

- `MONGODB_URI`
- `FIREBASE_CONFIG_PATH`
- `JWT_SECRET`

---

## 📜 License

MIT License

