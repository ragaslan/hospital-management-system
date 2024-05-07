package com.derman.controller;
import com.derman.database.Db;
import com.derman.model.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientController {

    public static Patient getPatientbyTC(String tc){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from patient where tc = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setString(1,tc);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    Patient patient = new Patient(
                            resultSet.getInt("id"),
                            resultSet.getString("tc"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("phone"),
                            resultSet.getString("address"),
                            resultSet.getString("blood"),
                            resultSet.getString("alergies"),
                            resultSet.getString("diseases")
                    );

                    return patient;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }



    // get ALL patients
    public static List<Patient> getAll(){
        List<Patient> patientList = new ArrayList<Patient>();

        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from patient";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    patientList.add(new Patient(
                            resultSet.getInt("id"),
                            resultSet.getString("tc"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("phone"),
                            resultSet.getString("address"),
                            resultSet.getString("blood"),
                            resultSet.getString("alergies"),
                            resultSet.getString("diseases")
                    ));
                }
                return patientList;
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }
}