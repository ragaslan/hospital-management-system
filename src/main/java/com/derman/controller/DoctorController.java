package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Account;
import com.derman.model.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorController {
    public static Doctor getDoctorById(int id){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from account where id = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,id);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    Doctor doctor = new Doctor(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("password"),
                            resultSet.getString("role"),
                            null
                    );
                    return doctor;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

}
