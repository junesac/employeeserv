DROP TABLE IF EXISTS emplooyees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  date_of_birth DATE DEFAULT NULL,
  address_id INT
);

DROP TABLE IF EXISTS Address;

CREATE TABLE Address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  line1 VARCHAR(250) NOT NULL,
  line2 VARCHAR(250),
  city VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  country VARCHAR(250) NOT NULL,
  zip_code VARCHAR(250) NOT NULL
);