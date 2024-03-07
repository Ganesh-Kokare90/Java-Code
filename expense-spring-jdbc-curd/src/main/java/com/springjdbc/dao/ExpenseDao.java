package com.springjdbc.dao;

import com.springjdbc.model.Expense;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ExpenseDao {

    JdbcTemplate jdbcTemplate;

    public void addExpense(Expense expense ){
        String sql="insert into expense_manager.Expense(id,remark,amount,payment_mode,LocalDateTime) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,preparedStatement -> {
            preparedStatement.setInt(1,expense.getId());
            preparedStatement.setString(2,expense.getRemark());
            preparedStatement.setInt(3,expense.getAmount());
            preparedStatement.setString(4, expense.getPayment_mode());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(expense.getLocalDateTime()));




        });


    }

    public void updateExpense(Expense expense ){
        String sql="update Expense set remark=?,amount=?,payment_mode=?,LocalDateTime=?  where id=?";
        jdbcTemplate.update(sql,preparedStatement -> {

            preparedStatement.setString(1,expense.getRemark());
            preparedStatement.setInt(2,expense.getAmount());
            preparedStatement.setString(3, expense.getPayment_mode());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(expense.getLocalDateTime()));
            preparedStatement.setInt(5,expense.getId());




        });

    }

    public void deleteExpense(int id){
        String sql ="delete from Expense where id=?";

        jdbcTemplate.update(sql,preparedStatement -> {
            preparedStatement.setInt(1,id);
        });
    }




    public List<Expense> getAllExpenses(){
        String sql="select * from Expense";
        ResultSetExtractor<List<Expense>> resultSet = (rs -> {
            List<Expense> expenseList = new ArrayList<>();
            while (rs.next()){
             Expense expense=   Expense.builder()
                        .id(rs.getInt("id"))
                        .remark(rs.getString("remark"))
                        .amount(rs.getInt("amount"))
                        .payment_mode(rs.getString("payment_mode"))
                        .LocalDateTime(rs.getTimestamp("LocalDateTime").toLocalDateTime())
                        .build();

                expenseList.add(expense);
            }

            return expenseList;

        });

        return jdbcTemplate.query(sql,resultSet);

    }

    public Expense getExpenseById(int id){
        String sql="select * from Expense where id=?"+id;
        RowMapper<Expense> rowMapper = (rs, rowNum) -> Expense.builder()
                .id(rs.getInt("id"))
                .remark(rs.getString("remark"))
                .amount(rs.getInt("amount"))
                .payment_mode(rs.getString("payment_mode"))
                .LocalDateTime(rs.getTimestamp("LocalDateTime").toLocalDateTime())

                .build();


        return jdbcTemplate.queryForObject(sql,rowMapper);
    }



}
