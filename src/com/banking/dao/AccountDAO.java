// src/com/banking/dao/AccountDAO.java
package com.banking.dao;

import com.banking.config.DatabaseConfig;
import com.banking.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public Account getAccountById(int id) {
        Account account = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    account = new Account(rs.getInt("id"), rs.getString("account_number"),
                            rs.getString("account_type"), rs.getDouble("balance"),
                            rs.getInt("customer_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account getAccountByNumber(String account_number) {
        Account account = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE account_number = ?")) {
            stmt.setString(1, account_number);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    account = new Account(rs.getInt("id"), rs.getString("account_number"),
                            rs.getString("account_type"), rs.getDouble("balance"),
                            rs.getInt("customer_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {
            while (rs.next()) {
                accounts.add(new Account(rs.getInt("id"), rs.getString("account_number"),
                        rs.getString("account_type"), rs.getDouble("balance"),
                        rs.getInt("customer_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public String createAccount(Account account) {
        String sql = "INSERT INTO accounts (account_number, account_type, balance, customer_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getaccount_number());
            stmt.setString(2, account.getaccount_type());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getcustomer_id());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Account created successfully.";
            } else {
                return "Failed to create account.";
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            return "Error: Account number already exists.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Unable to create account.";
        }
    }

    public boolean updateAccount(Account account) {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET account_number = ?, account_type = ?, balance = ?, customer_id = ? WHERE id = ?")) {
            stmt.setString(1, account.getaccount_number());
            stmt.setString(2, account.getaccount_type());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getcustomer_id());
            stmt.setInt(5, account.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(int id) {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM accounts WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
