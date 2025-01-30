CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50)
);

CREATE TABLE parking_spots (
    id INT AUTO_INCREMENT PRIMARY KEY,
    spot_number INT NOT NULL,
    is_available BOOLEAN DEFAULT TRUE
);

INSERT INTO users (first_name, last_name) VALUES ('John', 'Doe');
INSERT INTO parking_spots (spot_number, is_available) VALUES (1, true), (2, true), (3, false);