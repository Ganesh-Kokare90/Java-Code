package com.jdbc.controller;

import com.jdbc.model.Expense;
import com.jdbc.service.ExpenseService;

import java.sql.SQLException;
import java.util.List;

public class ExpenseController {
    ExpenseService expenseService = new ExpenseService();
    public void addExpense(Expense expense) throws SQLException {
        expenseService.addExpense(expense);
    }

    public void updateExpense(Expense expense) throws SQLException {
        expenseService.updateExpense(expense);
    }

    public void deleteExpense(int id) throws SQLException {
        expenseService.deleteExpense(id);
    }

    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }




}
