package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Patient;
import com.derman.model.Treatment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TreatmentController {

    public static void createTreatment(Treatment treatment, int doctorId){
        try(var connection = Db.connect()){
            if (connection != null){
                String sql = "insert into treatment (doctor_id,complaint,tests,diagnosis,prescriptions) values(?,?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, doctorId);
                pstmt.setString(2, treatment.getComplaint());
                pstmt.setString(3, treatment.getTests());
                pstmt.setString(4, treatment.getDiagnosis());
                pstmt.setString(5, treatment.getPrescriptions());

                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
