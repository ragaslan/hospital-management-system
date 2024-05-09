package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Doctor;
import com.derman.model.Polyclinic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PolyclinicController {

    public static void createPolyclinic(Polyclinic polyclinic) {
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "insert into polyclinic (name) values(?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, polyclinic.getName());

                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static Polyclinic getPolyclinicById(int id){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from polyclinic where id = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,id);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    Polyclinic polyclinic = new Polyclinic(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    );
                    return polyclinic;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static List<Polyclinic> getAllPolyclinics(){
        List<Polyclinic> polyclinicList = new ArrayList<>();
        int i = 0;
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from polyclinic";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    Polyclinic polyclinic = new Polyclinic(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    );
                    polyclinicList.add(polyclinic);
                }
                return polyclinicList;
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

}
