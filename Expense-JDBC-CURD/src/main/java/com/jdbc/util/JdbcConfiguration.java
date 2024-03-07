package com.jdbc.util;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jdbc.constants.DbConstants.*;

public class JdbcConfiguration {
    @Getter
    private static Connection connection;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        try {
            connection= DriverManager.getConnection(MYSQL_URL,MYSQL_USERNAME,MYSQL_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Issue in connection");


        }
    }
}
