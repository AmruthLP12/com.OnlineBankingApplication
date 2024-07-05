// src/com/banking/ui/CustomerUI.java
package com.banking.ui;

import com.banking.model.Customer;
import com.banking.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {
    private CustomerService customerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("=== Customer Management ===");
            System.out.println("1. View Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Create Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewCustomer();
                    break;
                case 2:
                    viewAllCustomers();
                    break;
                case 3:
                    createCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void viewCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        Customer customer = customerService.getCustomerDetails(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void viewAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void createCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(0, name, email, phone);
        if (customerService.createCustomer(customer)) {
            System.out.println("Customer created successfully.");
        } else {
            System.out.println("Failed to create customer.");
        }
    }

    private void updateCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customer = customerService.getCustomerDetails(id);
        if (customer != null) {
            System.out.print("Enter new customer name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new customer email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new customer phone: ");
            String phone = scanner.nextLine();

            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            if (customerService.updateCustomer(customer)) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Failed to update customer.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void deleteCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        if (customerService.deleteCustomer(id)) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Failed to delete customer.");
        }
    }
}
