package com.springjdbc.service;

import com.springjdbc.dao.ExpenseDao;
import com.springjdbc.model.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor



public class ExpenseService {
    ExpenseDao expenseDao;

    public void addExpense(Expense expense)  {
        expenseDao.addExpense(expense);
    }

    public void updateExpense(Expense expense)  {
        expenseDao.updateExpense(expense);
    }

    public void deleteExpense(int id)  {
        expenseDao.deleteExpense(id);
    }

    public List<Expense> getAllExpenses(){
        return expenseDao.getAllExpenses();
    }

}
