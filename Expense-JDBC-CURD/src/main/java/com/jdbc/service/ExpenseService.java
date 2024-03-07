package com.jdbc.service;

import com.jdbc.dao.ExpenseDao;
import com.jdbc.model.Expense;

import java.sql.SQLException;
import java.util.List;

public class ExpenseService {
    ExpenseDao expenseDao = new ExpenseDao();

    public void addExpense(Expense expense) throws SQLException {
        expenseDao.addExpense(expense);
    }

    public void updateExpense(Expense expense) throws SQLException {
        expenseDao.updateExpense(expense);
    }

    public void deleteExpense(int id) throws SQLException {
        expenseDao.deleteExpense(id);
    }

    public List<Expense> getAllExpenses(){
        return expenseDao.getAllExpenses();
    }
}
