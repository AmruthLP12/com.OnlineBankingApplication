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
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM accounts WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                account = new Account(
                        rs.getInt("id"),
                        rs.getString("account_number"),
                        rs.getString("account_type"),
                        rs.getDouble("balance"),
                        rs.getInt("customer_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("id"),
                        rs.getString("account_number"),
                        rs.getString("account_type"),
                        rs.getDouble("balance"),
                        rs.getInt("customer_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean createAccount(Account account) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO accounts (account_number, account_type, balance, customer_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, account.getAccountNumber());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getCustomerId());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAccount(Account account) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "UPDATE accounts SET account_number = ?, account_type = ?, balance = ?, customer_id = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, account.getAccountNumber());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getCustomerId());
            stmt.setInt(5, account.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(int id) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "DELETE FROM accounts WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
