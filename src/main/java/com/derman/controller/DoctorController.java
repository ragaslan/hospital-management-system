package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Account;
import com.derman.model.Doctor;
import com.derman.model.Polyclinic;

import javax.print.Doc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                            resultSet.getString("phone"),
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

    public static List<Doctor> getAllDoctorByPolyclinicId(int polyclinicId){
        List<Doctor> allDoctors = new ArrayList<>();
        Polyclinic polyclinic = PolyclinicController.getPolyclinicById(polyclinicId);
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from account where polyclinic_id = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,polyclinicId);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    Doctor doctor = new Doctor(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("phone"),
                            null,
                            resultSet.getString("role"),
                            polyclinic
                    );
                    allDoctors.add(doctor);
                }
                return allDoctors;
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static void createDoctor(Doctor doctor) {
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "insert into account(username, name , surname, password, role, phone, polyclinic_id) values(?,?,?,?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, doctor.getUsername());
                pstmt.setString(2, doctor.getName());
                pstmt.setString(3, doctor.getSurname());
                pstmt.setString(4, doctor.getPassword());
                pstmt.setString(5, doctor.getRole());
                pstmt.setString(6,doctor.getPhone());
                pstmt.setInt(7, doctor.getPolyclinic().getId());

                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
