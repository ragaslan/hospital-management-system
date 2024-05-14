package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Patient;
import com.derman.model.Treatment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreatmentController {

    public static void createTreatment(Treatment treatment){
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "insert into treatment (doctor_id,patient_id,complaint,tests,diagnosis,prescriptions) values(?,?,?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, treatment.getDoctor().getId());
                pstmt.setInt(2, treatment.getPatient().getId());
                pstmt.setString(3, treatment.getComplaint());
                pstmt.setString(4, treatment.getTests());
                pstmt.setString(5, treatment.getDiagnosis());
                pstmt.setString(6, treatment.getPrescriptions());

                pstmt.executeUpdate();

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static Treatment getTreatmentByPatientId(int id){
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "select * from treatment where patient_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, id);
                ResultSet result = pstmt.executeQuery();
                //System.out.println(result);
                if(result.next()){

                    Treatment treatment = new Treatment(
                            result.getInt("id"),
                            null,
                            null,
                            null,
                            result.getString("tests"),
                            result.getString("diagnosis"),
                            null
                            );
                    return treatment;
                }else{
                    return null;
                }
            }
            return null;
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static boolean deleteTreatment(int id){
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "delete from treatment where patient_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1,id);
                return pstmt.executeUpdate() == 1;
            }
            return false;
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

}
