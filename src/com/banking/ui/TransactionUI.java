// src/com/banking/ui/TransactionUI.java
package com.banking.ui;

import com.banking.model.Transaction;
import com.banking.service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class TransactionUI {
    private TransactionService transactionService = new TransactionService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("=== Transaction Management ===");
            System.out.println("1. Create Transaction");
            System.out.println("2. View Transactions by Account ID");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTransaction();
                    break;
                case 2:
                    viewTransactionsByAccountId();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void createTransaction() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter transaction type (DEPOSIT, WITHDRAWAL, TRANSFER): ");
        String transactionType = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Transaction transaction = new Transaction(0, accountId, transactionType, amount, null);
        if (transactionService.createTransaction(transaction)) {
            System.out.println("Transaction created successfully.");
        } else {
            System.out.println("Failed to create transaction.");
        }
    }

    private void viewTransactionsByAccountId() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
