package com.sparta.employeecsv.model.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableFactory {
    public static void createTable() {
            Connection conn = ConnectionFactory.getConnection();

            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("DROP TABLE IF EXISTS employees;");
                statement.executeUpdate("""
                        CREATE TABLE Employees (
                            EmployeeID int,
                            NamePrefix varchar(255),
                            FirstName varchar(255),
                            MiddleInitial varchar(255),
                            LastName varchar(255),
                            Gender varchar(255),
                            Email varchar(255),
                            DateOfBirth date,
                            DateOfJoining date,
                            salary int
                        );""");

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


}
