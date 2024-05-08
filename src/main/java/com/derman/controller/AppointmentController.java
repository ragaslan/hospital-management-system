package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Appointment;
import com.derman.model.Doctor;
import com.derman.model.Patient;
import com.derman.model.Polyclinic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentController {

    public static Appointment findAppointmentByPatientId(int patientId){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from appointment where patient_id = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,patientId);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    int doctor_id = resultSet.getInt("doctor_id");
                    Doctor doktor = DoctorController.getDoctorById(doctor_id);
                    int polyclinic_id = resultSet.getInt("polyclinic_id");
                    Polyclinic polyclinic = PolyclinicController.getPolyclinicById(polyclinic_id);
                    int patient_id = resultSet.getInt("patient_id");
                    Patient patient = PatientController.getPatientById(patientId);

                    Appointment appointment = new Appointment(
                            resultSet.getInt("id"),
                            doktor,
                            patient,
                            polyclinic,
                            resultSet.getInt("month"),
                            resultSet.getInt("day"),
                            resultSet.getInt("hour"),
                            resultSet.getInt("minute")
                    );
                    return appointment;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }


}
