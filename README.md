# Scientific Calculator (DevOps Project)

A specialized Scientific Calculator built  and deployed using a full **DevOps CI/CD pipeline**. This project demonstrates the integration of automation tools for building, testing, containerizing, and deploying a web-based calculator.

## 🚀 Project Overview
The application provides four key mathematical operations via a REST API and a modern, user-friendly HTML interface:
- **Square Root ($\sqrt{x}$)**
- **Factorial ($x!$)**
- **Natural Log ($\ln(x)$)**
- **Power ($x^b$)**

## 🛠️ DevOps Toolchain
- **Language**: Java 17 (Spring Boot)
- **SCM**: Git & GitHub
- **Build Tool**: Maven
- **CI/CD**: Jenkins (Webhook triggered)
- **Containerization**: Docker
- **Configuration Management**: Ansible

---

## 🏗️ Build & Deployment Pipeline Stages

The project follows a fully automated **Continuous Integration and Continuous Deployment (CI/CD)** lifecycle. Below are the stages defined in the `Jenkinsfile` and executed during each build:

### 1. Source Control Management (SCM)
- **Action**: Jenkins clones the latest code from the GitHub repository.
- **Trigger**: Automatically triggered by a GitHub Webhook on every `push`.

### 2. Maven Build & Package
- **Action**: Compiles the Java source code and packages it into a JAR file.
- **Goal**: Ensures there are no compilation errors.

### 3. Unit Testing
- **Action**: Runs all JUnit test cases.
- **Goal**: Validates the mathematical logic (e.g., verifying square root of 16 is 4.0).

### 4. Docker Containerization
- **Action**: Builds a Docker image using the `Dockerfile` and tags it as `abhashti/calculator:latest`.
- **Goal**: Packages the JAR with its runtime environment.

### 5. Docker Hub Distribution
- **Action**: Pushes the newly built image to **Docker Hub**.
- **Goal**: Makes the image available for deployment on any environment.

### 6. Ansible Deployment
- **Action**: Jenkins triggers an Ansible Playbook (`deploy.yml`) on the production VM.
- **Logic**: 
  - Stops and removes any existing containers on port 8081.
  - Pulls the latest image from Docker Hub.
  - Runs a new container instance, exposing the scientific calculator UI.

---

## 💻 How to Access the Project

There are three ways to run and interact with the Scientific Calculator:

### 1. Remote Server (Production)
The project is automatically deployed to a remote VM via Jenkins and Ansible.
- **URL**: [http://172.16.180.127:8081/](http://172.16.180.127:8081/)
- **Usage**: Simply open the link in any browser to use the HTML UI.

### 2. Local Host (Maven/Source Code)
If you want to run it directly from the source code on your own machine.
- **Requirement**: Java 17 installed.
- **Commands**:
  ```bash
  cd calculator
  ./mvnw spring-boot:run
  ```
- **URL**: [http://localhost:8080/](http://localhost:8080/)

### 3. Local Docker (Containerized)
Run the application using the pre-built Docker image from Docker Hub.
- **Requirement**: Docker installed.
- **Commands**:
  ```bash
  docker pull abhashti/calculator:latest
  docker run -d --name scicalc -p 8080:8080 abhashti/calculator:latest
  ```
- **URL**: [http://localhost:8080/](http://localhost:8080/)

---

## 🔒 Error Handling
The application includes robust error handling for invalid mathematical operations (e.g., negative square roots or factorial of large numbers). These errors are displayed clearly in the UI to guide the user.

