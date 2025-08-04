package com.JdbcCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    //CREATE
    /*public void addEmployee(Employee emp){
        String sql="INSERT INTO employees (id,name,role )VALUES(?,?,?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getRole());
            stmt.executeUpdate();
                System.out.println("Employee added successfully"+emp );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        String sql ="Select * from employees";
        try(Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return list;
    }


    public void updateEmployeeRole(int id,String role){
        String sql="UPDATE employees SET role=? WHERE id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,role);
            stmt.setInt(2,id);
            stmt.executeUpdate();
        }catch (SQLException e){}
    }

    //Delete
    public void deleteEmployee(int id){

        String sql ="Delete from employees where id=?";
        try(Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully");
        }catch (SQLException e){}
    }

}
