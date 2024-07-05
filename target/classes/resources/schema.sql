-- src/resources/schema.sql

-- Drop existing database
DROP DATABASE IF EXISTS banking;

-- Create database
CREATE DATABASE banking;

-- Use the created database
USE banking;

-- Table for customers
CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for accounts
CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    account_type ENUM('SAVINGS', 'CHECKING', 'BUSINESS') NOT NULL,
    balance DOUBLE NOT NULL DEFAULT 0.0,
    customer_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Table for transactions
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    amount DOUBLE NOT NULL,
    type ENUM('DEPOSIT', 'WITHDRAWAL', 'TRANSFER') NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Sample data insertion
INSERT INTO customers (name, email, phone) VALUES
('John Doe', 'john.doe@example.com', '123-456-7890'),
('Jane Smith', 'jane.smith@example.com', '098-765-4321');

INSERT INTO accounts (account_number, account_type, balance, customer_id) VALUES
('ACC1001', 'SAVINGS', 1500.00, 1),
('ACC1002', 'CHECKING', 500.00, 2),
('ACC1003', 'BUSINESS', 2500.00, 1);

INSERT INTO transactions (account_id, amount, type) VALUES
(1, 200.00, 'DEPOSIT'),
(1, -50.00, 'WITHDRAWAL'),
(2, 100.00, 'DEPOSIT'),
(3, 500.00, 'TRANSFER');
