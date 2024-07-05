// src/com/banking/service/CustomerService.java
package com.banking.service;

import com.banking.dao.CustomerDAO;
import com.banking.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public Customer getCustomerDetails(int id) {
        return customerDAO.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public boolean createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    public boolean deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }
}
