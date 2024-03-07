package com.springjdbc;

import com.springjdbc.controller.ExpenseController;
import com.springjdbc.model.Expense;
import com.springjdbc.util.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ExpenseController expenseController = applicationContext.getBean(ExpenseController.class);

     /*   expenseController.addExpense(Expense.builder()
                        .remark("Bhel")
                        .amount(35)
                        .payment_mode("Cash")
                        .LocalDateTime(LocalDateTime.now())
                .build()); */
        expenseController.updateExpense(Expense.builder()
                        .payment_mode("Phone Pay")
                        .remark("Bhel")
                        .amount(35)
                        .LocalDateTime(LocalDateTime.now())
                        .id(107)

                .build());
       /* expenseController.deleteExpense(109); */
//expenseController.getAllExpenses().forEach(System.out::println);





    }
}
