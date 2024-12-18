

---
![api-testing](https://raw.githubusercontent.com/abhishekaryangiri/spring/main/quiz-app/src/main/resources/static/images/api-testing.gif)

![api-testing](src/main/resources/static/images/api-testing.gif)
![api-testing](images/api-testing.gif)
# QUIZ-APP: API Testing on Postman


---

### 1. **Start Quiz**

**Endpoint:** `POST /api/quiz/start/{userId}`

** Request:**  
```http
POST http://localhost:8080/api/quiz/start/7
```

**Output:**  
```json
"Quiz session started for user: 7"
```

This starts a new quiz session for the user with the given `userId`. Replace `7` with the appropriate user ID.

---

### 2. **Fetch Question**

**Endpoint:** `GET /api/quiz/question`

** Request:**  
```http
GET http://localhost:8080/api/quiz/question
```

**Output:**  
```json
{
    "id": 1,
    "question": "What is the default value of a boolean variable in Java?",
    "option1": "true",
    "option2": "false",
    "option3": "0",
    "option4": "1",
    "correctOption": 2
}
```

This endpoint retrieves a random question from the quiz. The options and the correct answer are returned.

---

### 3. **Process Question**

**Endpoint:** `GET /api/quiz/process?questionId={questionId}`

** Request:**  
```http
GET http://localhost:8080/api/quiz/process?questionId=7
```

**Output:**  
```json
"Question processed: 7"
```

This endpoint processes the question by its `questionId`. Replace `7` with the question ID you want to process.

---

### 4. **Submit Answer**

**Endpoint:** `POST /api/quiz/submit/{userId}`

** Request:**  
```http
POST http://localhost:8080/api/quiz/submit/7?questionId=1&selectedOption=2
```

**Output (Correct Answer):**  
```json
"Correct answer!"
```

**Output (Incorrect Answer):**  
```json
"Wrong answer!"
```

This endpoint submits the selected answer for a given `userId` and `questionId`. It also checks if the selected option is correct or not.

---

### 5. **Check Result**

**Endpoint:** `GET /api/quiz/result/{userId}`

** Request (for userId = 7):**  
```http
GET http://localhost:8080/api/quiz/result/7
```

**Output (for userId = 7):**  
```json
{
    "Total Questions": 1,
    "Correct Answers": 1,
    "Incorrect Answers": 0
}
```

This endpoint provides the result of the quiz for a specific user by their `userId`. It returns the total number of questions, the correct answers, and the incorrect answers.

---

**Request (for userId = 1):**  
```http
GET http://localhost:8080/api/quiz/result/1
```

***Output (for userId = 1):**  
```json
{
    "Total Questions": 7,
    "Correct Answers": 4,
    "Incorrect Answers": 3
}
```
## Tech Stack Used to Build This Quiz App API

- **Spring Boot**: Framework for building the backend API.
- **Java**:  Core programming language used for backend development
- **MySQL**: Relational database for storing user data and quiz information.
- **Hibernate**: ORM for interacting with the database.
- **GitHub**: Version control and repository management.
- **Maven**: Build automation tool for dependency management and project builds.
- **Apache Tomcat**: Web server for deploying the Spring Boot application.
- **Spring Initializr**: Tool for generating the Spring Boot project structure.
- **REST API**: Architecture style for building the API endpoints.

---



# How to Clone, Run, and Test the Spring Boot App

## 1. Clone the Repository

### Option 1: Clone the Repository Using Git

1. Install Git if it's not already installed.
   
2. Download the repository to your local machine and unzip it:
   ```bash
   https://github.com/abhishekaryangiri/quiz-app.git
   ```
Navigate to the project directory:
```bash
cd desktop/github/quiz-app  # Use your local path
```
3. Import project in IDE(Eclipse/STS).
4. Set-up: Db, properties file etc.
5. Run as Springboot App.
6. Test ApPI's on postman.

### Option 2: Clone the Repository
```bash
   git clone https://github.com/abhishekaryangiri/quiz-app.git
```
```bash
   cd desktop/github/quiz-app  # Use your local path
```

## 3. Test with Postman
1. Install Postman.
2. Use `http://localhost:8080` as the base URL.
3. Test endpoints:
   - **GET**: Enter URL and click **Send**.
   - **POST**: Add JSON payload in the **Body** tab under `raw > JSON`.
   - **PUT/DELETE**: Follow similar steps with respective HTTP methods.

4. Add headers if required (e.g., `Authorization` for tokens).

## 4. mySql
- Ensure the database is running .
- Update `application.properties` with database credentials or configs.
- #  Database Schema

## 1. Create Database

```sql
CREATE DATABASE quiz_db;
USE quiz_db;
2. Create Tables
Table: question
```

```sql
CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    correct_option INT NOT NULL
);
```

Table: quiz_session

```sql
CREATE TABLE quiz_session (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    questionId INT NOT NULL,
    selectedOption INT NOT NULL,
    isCorrect BOOLEAN NOT NULL
);
```
3. Insert Sample Questions
```sql
INSERT INTO question (question, option1, option2, option3, option4, correct_option) VALUES
('What is the default value of a boolean variable in Java?', 'true', 'false', '0', '1', 2),
('Which of the following is not a valid data type in Java?', 'int', 'long', 'float', 'dec', 4),
('Which method is used to start a thread in Java?', 'start()', 'run()', 'sleep()', 'initialize()', 1),
('What is the size of a char in Java?', '8 bits', '16 bits', '32 bits', '64 bits', 2),
('Which collection class allows duplicate elements?', 'HashSet', 'TreeSet', 'HashMap', 'ArrayList', 4),
('Which of the following is used to declare an array in Java?', 'array[]', '[]array', 'Array[]', 'int[]', 4),
('What is the output of the following code snippet: System.out.println(10 / 3)?', '3', '3.33', '3.0', '0', 1),
('Which of these is used to define an interface in Java?', 'interface', 'implements', 'extends', 'defining', 1),
('Which of the following is not a valid identifier in Java?', 'int', 'super', 'new', 'final', 3),
('What is the correct syntax for a method in Java?', 'public static void method() {}', 'void static public method() {}', 'static void method() {}', 'public method() {}', 1),
('Which of the following classes is used for storing key-value pairs in Java?', 'List', 'Set', 'Map', 'Queue', 3),
('Which access modifier allows access to a variable from any class?', 'private', 'protected', 'public', 'default', 3);
```


```


