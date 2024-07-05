// src/com/banking/ui/Main.java
package com.banking.ui;

import com.banking.model.Account;
import com.banking.service.AccountService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static AccountService accountService = new AccountService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. View Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Create Account");
            System.out.println("4. Update Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewAccount(scanner);
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    updateAccount(scanner);
                    break;
                case 5:
                    deleteAccount(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }

    private static void viewAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        Account account = accountService.getAccountDetails(accountId);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account type (SAVINGS, CHECKING, BUSINESS): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        Account account = new Account(0, accountNumber, accountType, balance, customerId);
        if (accountService.createAccount(account)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Failed to create account.");
        }
    }

    private static void updateAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Account account = accountService.getAccountDetails(accountId);
        if (account != null) {
            System.out.print("Enter new account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter new account type (SAVINGS, CHECKING, BUSINESS): ");
            String accountType = scanner.nextLine();
            System.out.print("Enter new balance: ");
            double balance = scanner.nextDouble();
            System.out.print("Enter new customer ID: ");
            int customerId = scanner.nextInt();

            account.setAccountNumber(accountNumber);
            account.setAccountType(accountType);
            account.setBalance(balance);
            account.setCustomerId(customerId);

            if (accountService.updateAccount(account)) {
                System.out.println("Account updated successfully.");
            } else {
                System.out.println("Failed to update account.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deleteAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        if (accountService.deleteAccount(accountId)) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Failed to delete account.");
        }
    }
}
