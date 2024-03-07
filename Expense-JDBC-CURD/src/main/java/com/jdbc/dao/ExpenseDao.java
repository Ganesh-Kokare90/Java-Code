package com.jdbc.dao;

import com.jdbc.model.Expense;
import com.jdbc.util.JdbcConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    public void addExpense(Expense expense) throws SQLException {
        Connection connection = JdbcConfiguration.getConnection();
        String sql="insert into expense_manager.Expense(id,remark,amount,payment_mode,LocalDateTime) values(?,?,?,?,?)";

        PreparedStatement preparedStatement= connection.prepareStatement(sql);

        preparedStatement.setInt(1,expense.getId());
        preparedStatement.setString(2,expense.getRemark());
        preparedStatement.setInt(3,expense.getAmount());
        preparedStatement.setString(4, expense.getPayment_mode());
        preparedStatement.setTimestamp(5, Timestamp.valueOf(expense.getLocalDateTime()));
        preparedStatement.executeUpdate();
        System.out.println("Expense Added");
        connection.close();




    }



    public void updateExpense(Expense expense) throws SQLException {
        Connection connection = JdbcConfiguration.getConnection();
        String sql="update Expense set remark=?,amount=?,payment_mode=?,LocalDateTime=?  where id=?";

        PreparedStatement preparedStatement= connection.prepareStatement(sql);


        preparedStatement.setString(1,expense.getRemark());
        preparedStatement.setInt(2,expense.getAmount());
        preparedStatement.setString(3, expense.getPayment_mode());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(expense.getLocalDateTime()));
        preparedStatement.setInt(5,expense.getId());
        preparedStatement.executeUpdate();
        System.out.println("Expense Updated");
        connection.close();


    }

    public void deleteExpense(int id) throws SQLException {
        Connection connection = JdbcConfiguration.getConnection();
        String sql="Delete from Expense where id=?";

        PreparedStatement preparedStatement= connection.prepareStatement(sql);



        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        System.out.println("Expense Deleted");
        connection.close();


    }


    public List<Expense> getAllExpenses(){
        Connection connection = JdbcConfiguration.getConnection();
        String sql="select  * from Expense";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            List<Expense> expenseList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Expense expense = Expense.builder()
                        .id(resultSet.getInt("id"))
                        .remark(resultSet.getString("remark"))
                        .amount(resultSet.getInt("amount"))
                        .payment_mode(resultSet.getString("payment_mode"))
                        .LocalDateTime(resultSet.getTimestamp("LocalDateTime").toLocalDateTime())
                        .build();
                expenseList.add(expense);

            }

            return expenseList;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }




}
