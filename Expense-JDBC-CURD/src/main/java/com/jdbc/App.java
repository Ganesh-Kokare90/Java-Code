package com.jdbc;

import com.jdbc.controller.ExpenseController;
import com.jdbc.dao.ExpenseDao;
import com.jdbc.model.Expense;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        ExpenseController expenseController = new ExpenseController();





        /* expenseController.addExpense(Expense.builder()
                        .remark("Pohe")
                        .amount(50)
                        .payment_mode("Google Pay")
                        .LocalDateTime(LocalDateTime.now())
                .build()); */
     /*  expenseController.updateExpense(Expense.builder()
                .remark("Burger")
                        .amount(140)
                        .LocalDateTime(LocalDateTime.now())
                        .payment_mode("Cash")
                        .id(107)

                .build());*/ 
      expenseController.getAllExpenses().forEach(System.out::println);
       // System.out.println(expenseController.getAllExpenses());



    }
}
