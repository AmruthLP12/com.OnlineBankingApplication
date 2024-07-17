// src/com/banking/ui/AccountUI.java
package com.banking.ui;

import com.banking.model.Account;
import com.banking.service.AccountService;

import java.util.List;
import java.util.Scanner;

public class AccountUI {
    private AccountService accountService = new AccountService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("=== Account Management ===");
            System.out.println("1. View Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Create Account");
            System.out.println("4. Update Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    deleteAccount();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void viewAccount() {
        Account account = selectAccount();
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void viewAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        String accountType = selectAccountType();

        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Account account = new Account(0, accountNumber, accountType, balance, customerId);
        if (accountService.createAccount(account)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Failed to create account.");
        }
    }

    private void updateAccount() {
        Account account = selectAccount();
        if (account != null) {
            System.out.println("Current account details: " + account);
            System.out.print("Enter new account number: ");
            String accountNumber = scanner.nextLine();

            String accountType = selectAccountType();

            System.out.print("Enter new balance: ");
            double balance = scanner.nextDouble();
            System.out.print("Enter new customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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

    private void deleteAccount() {
        Account account = selectAccount();
        if (account != null) {
            System.out.println("Deleting account: " + account);
            if (accountService.deleteAccount(account.getId())) {
                System.out.println("Account deleted successfully.");
            } else {
                System.out.println("Failed to delete account.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account selectAccount() {
        List<Account> accounts = accountService.getAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.println("Available accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }

        System.out.print("Select account by number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= accounts.size()) {
            return accounts.get(choice - 1);
        } else {
            System.out.println("Invalid selection. Returning to menu.");
            return null;
        }
    }

    private String selectAccountType() {
        int typeChoice;
        String accountType = "";
        do {
            System.out.println("Select account type:");
            System.out.println("1. SAVINGS");
            System.out.println("2. CHECKING");
            System.out.println("3. BUSINESS");
            System.out.print("Enter your choice: ");
            typeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (typeChoice) {
                case 1:
                    accountType = "SAVINGS";
                    break;
                case 2:
                    accountType = "CHECKING";
                    break;
                case 3:
                    accountType = "BUSINESS";
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (typeChoice < 1 || typeChoice > 3);

        return accountType;
    }
}
