package com.sparta.employeecsv.model.database;

import com.sparta.employeecsv.model.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBDriver {
    public static void databaseWriter(HashMap<Integer, Employee> employees) {

        try{
            Connection conn= ConnectionFactory.getConnection();
            int rows = 0;
            System.out.println("yes");
            Statement statement = conn.createStatement();
            //                                              1           2           3       4               5       6       7       8           9            10
            String insertString = "INSERT INTO employees(EmployeeID,NamePrefix, FirstName,MiddleInitial, LastName,Gender, Email,DateOfBirth, DateOfJoining,salary) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertString);


            TableFactory.createTable();



            for (Integer id : employees.keySet()){
                Employee employee= employees.get(id);
                EmployeeDAO.createEmployee(employee);
                System.out.println(rows++);
//              statement.executeUpdate("INSERT INTO employees(EmployeeID,\n" +
//                        "NamePrefix, FirstName,\n" +
//                        "MiddleInitial, LastName,\n" +
//                        "Gender, Email,\n" +
//                        "DateOfBirth, DateOfJoining,\n" +
//                        "salary\n" +
//                        ") VALUES("+employee.getId()+",'" + employee.getPrefix()+"','"
//                        + employee.getFirstName()+"','" + employee.getMiddleInitial()+"','"
//                        + employee.getLastName()+"','" + employee.isGender()+"','"
//                        + employee.getEmail()+"','" + employee.getDateOfBirth()+"','"
//                        + employee.getDateOfJoining()+"'," + employee.getSalary()+");");
            }
            // Example of code for retrieving data
//            Employee foundEmployee=EmployeeDAO.getEmployeeById(425467);
//            System.out.println(foundEmployee.getId()+",'" + foundEmployee.getPrefix()+"','"
//                        + foundEmployee.getFirstName()+"','" + foundEmployee.getMiddleInitial()+"','"
//                        + foundEmployee.getLastName()+"','" + foundEmployee.getGender()+"','"
//                        + foundEmployee.getEmail()+"','" + foundEmployee.getDateOfBirth()+"','"
//                        + foundEmployee.getDateOfJoining()+"'," + foundEmployee.getSalary());


            statement.close();
            preparedStatement.close();

            //ConnectionFactory.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
