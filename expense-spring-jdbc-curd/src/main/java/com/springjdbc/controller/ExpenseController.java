package com.springjdbc.controller;

import com.springjdbc.model.Expense;
import com.springjdbc.service.ExpenseService;
import com.springjdbc.util.SpringConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;

@Controller
@AllArgsConstructor

public class ExpenseController {
    ExpenseService expenseService;
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
