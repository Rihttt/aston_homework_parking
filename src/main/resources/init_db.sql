CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50)
);

INSERT INTO users (first_name, last_name, email) VALUES ('John', 'Doe');