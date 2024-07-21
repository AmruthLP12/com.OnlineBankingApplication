
# Online Banking Application

An online banking application built with Java and MySQL, providing functionalities for account management, customer management, and transaction management.

## Table of Contents

- [Features](#Features)

- [Installation](#Installation) 

- [Database Setup](#database-setup)

- [Configuration](#Configuration)

- [Usage](#Usage)

- [Project Structure](#project-structure)

- [Contributing](CONTRIBUTING.md)

- [License](LICENSE.md)

## Features

* Manage Accounts:
    * View Account
    * View All Accounts
    * Create Account
    * Update Account
    * Delete Account
* Manage Customers
* Manage Transactions



# Installation

### Prerequisites

- Java 8+
- MySQL
- Maven

### Steps

1. Clone the repository 

```bash
git clone https://github.com/AmruthLP12/com.OnlineBankingApplication.git
cd online-banking-application
```
2. Build the project using Maven:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.banking.ui.Main"
```

 ## Database Setup

1. Create the database schema:

```sql
-- Drop existing database
DROP DATABASE IF EXISTS banking;

-- Create database
CREATE DATABASE banking;

-- Use the created database
USE banking;
```
2. Create the tables:

```sql
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


```

3. Populate the tables with initial data (optional):

```sql
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

```



## Configuration

Configure the database connection in` src/main/resources/config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/banking
db.username=root
db.password=your_password

```
## Usage

1. Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.banking.ui.Main"

```

2. Follow the on-screen prompts to manage accounts, customers, and transactions.

## Project Structure

```bash
online-banking-application/
│
├── src/
│   ├── com/
│   │   ├── banking/
│   │   │   ├── config/
│   │   │   │   └── DatabaseConfig.java
│   │   │   ├── dao/
│   │   │   │   └── AccountDAO.java
│   │   │   │   └── CustomerDAO.java
│   │   │   │   └── TransactionDAO.java
│   │   │   ├── model/
│   │   │   │   └── Account.java
│   │   │   │   └── Customer.java
│   │   │   │   └── Transaction.java
│   │   │   ├── service/
│   │   │   │   └── AccountService.java
│   │   │   │   └── CustomerService.java
│   │   │   │   └── TransactionService.java
│   │   │   ├── ui/
│   │   │       └── AccountUI.java
│   │   │       └── CustomerUI.java
│   │   │       └── TransactionUI.java
│   │   │       └── Main.java
│   ├── resources/
│   │   └── schema.sql
│
├── pom.xml
├── README.md
└── .gitignore


```



## Contributing

Contributions are always welcome!

See [CONTRIBUTING.md](CONTRIBUTING.md) for ways to get started.





## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

