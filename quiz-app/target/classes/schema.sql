CREATE DATABASE quiz_db;

USE quiz_db;

CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    correct_option INT NOT NULL
);

CREATE TABLE quiz_session (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    questionId INT NOT NULL,
    selectedOption INT NOT NULL,
    isCorrect BOOLEAN NOT NULL
);
