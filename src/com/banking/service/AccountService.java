// src/com/banking/service/AccountService.java
package com.banking.service;

import com.banking.dao.AccountDAO;
import com.banking.model.Account;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAO();

    public Account getAccountDetails(int id) {
        return accountDAO.getAccountById(id);
    }

    public Account getAccountByNumber(String account_number) {
        return accountDAO.getAccountByNumber(account_number);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    public boolean createAccount(Account account) {
        return accountDAO.createAccount(account);
    }

    public boolean updateAccount(Account account) {
        return accountDAO.updateAccount(account);
    }

    public boolean deleteAccount(int id) {
        return accountDAO.deleteAccount(id);
    }
}
