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

    public static void updatePatient(Patient patient){
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "UPDATE patient SET name = ?, surname = ?, phone = ?, address = ?, blood = ?, alergies = ?, diseases = ?, tc = ? WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1,patient.getName());
                pstmt.setString(2,patient.getSurname());
                pstmt.setString(3,patient.getPhone());
                pstmt.setString(4,patient.getAddress());
                pstmt.setString(5,patient.getBlood());
                pstmt.setString(6,patient.getAlergies());
                pstmt.setString(7,patient.getDiseases());
                pstmt.setString(8,patient.getTc());
                pstmt.setInt(9,patient.getId());

                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
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
