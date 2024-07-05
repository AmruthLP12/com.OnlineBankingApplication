// src/com/banking/ui/Main.java
package com.banking.ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountUI accountUI = new AccountUI();
        CustomerUI customerUI = new CustomerUI();
        TransactionUI transactionUI = new TransactionUI();

        int choice;
        do {
            System.out.println("=== Online Banking Application ===");
            System.out.println("1. Manage Accounts");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Transactions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    accountUI.showMenu();
                    break;
                case 2:
                    customerUI.showMenu();
                    break;
                case 3:
                    transactionUI.showMenu();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
