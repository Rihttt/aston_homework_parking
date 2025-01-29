CREATE TABLE IF NOT EXISTS users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(50) NOT NULL,
                       last_name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS parking_ticket (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT,
                       user_name VARCHAR(50),
                       place_id INT,
                       vehicle_id INT,
                       acquire_date VARCHAR(50),
                       expire_date VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS parking_place (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       floor INT,
                       place_number INT,
                       isEmpty BOOLEAN
);
CREATE TABLE IF NOT EXISTS vehicle(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       plate VARCHAR(50),
                       model VARCHAR(50),
                       release_year VARCHAR(50)
);
INSERT INTO users (first_name, last_name) VALUES ('John', 'Doe');

