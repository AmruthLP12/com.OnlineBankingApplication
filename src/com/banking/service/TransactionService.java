// src/com/banking/service/TransactionService.java
package com.banking.service;

import com.banking.dao.TransactionDAO;
import com.banking.model.Transaction;

import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public boolean createTransaction(Transaction transaction) {
        return transactionDAO.createTransaction(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) {
        return transactionDAO.getTransactionsByAccountId(accountId);
    }
}
