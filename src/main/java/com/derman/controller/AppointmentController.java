package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<Session> getAllAvailableAppointmentHours(int polyclinic_id, int doctor_id, int month, int day){
        List<Session> sessions = new ArrayList<>();
        // saatleri eklicez daha sonra db de olanları çıkarıcaz
        Integer startHour = 9;
        Integer finishHour = 17;
        int i = startHour;
        while(i <= finishHour){
            sessions.add(new Session(i,0));
            sessions.add(new Session(i,30));
            i++;
        }
        /*for (Session tempSession : sessions){
            System.out.println("Hour : " + tempSession.getHour() + " Minute : " + tempSession.getMinute());
        }*/

        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select hour,minute from appointment where polyclinic_id = ? and doctor_id = ? and month = ? and day = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,polyclinic_id);
                stmt.setInt(2,doctor_id);
                stmt.setInt(3,month);
                stmt.setInt(4,day);
                ResultSet resultSet = stmt.executeQuery();

                while(resultSet.next()){
                    int hourValue = resultSet.getInt("hour");
                    int minuteValue = resultSet.getInt("minute");

                    sessions.removeIf(tempSession -> tempSession.getHour() == hourValue && tempSession.getMinute() == minuteValue);

                }
                return sessions;
            }


        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static Boolean createAppointment(int doctor_id,int patient_id,int polyclinic_id,int month,int day,int hour,int minute){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "insert into appointment (doctor_id,patient_id,polyclinic_id,month,day,hour,minute) values (?,?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,doctor_id);
                stmt.setInt(2,patient_id);
                stmt.setInt(3,polyclinic_id);
                stmt.setInt(4,month);
                stmt.setInt(5,day);
                stmt.setInt(6,hour);
                stmt.setInt(7,minute);

                return stmt.executeUpdate() == 1;
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return false;
    }
}
