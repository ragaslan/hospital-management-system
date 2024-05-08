package com.derman.views.appointment;

import com.derman.Main;
import com.derman.controller.AppointmentController;
import com.derman.model.Appointment;
import com.derman.model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AppointmentRecordShow {
    private JButton geriButton;
    private JButton createPatientButton;
    private JPanel appointmentRecordShowPanel;
    private JTextField polyclinicField;
    private JTextField doctorField;
    private JTextField dateField;
    private JTextField timeField;
    private JLabel appointmentAlert;

    public JPanel getAppointmentRecordShowPanel() {
        return appointmentRecordShowPanel;
    }


    public AppointmentRecordShow(){


        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.goBack();
            }
        });

        appointmentRecordShowPanel.addComponentListener(new ComponentListener() {


            @Override
            public void componentResized(ComponentEvent componentEvent) {

            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {

            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                System.out.println(Main.visitedPages.toString());
                Patient patient = Main.patientSearchData;
                // find appointment with patient id
                if(Main.patientSearchData == null){
                    System.out.println("Veri gelmedi");
                    polyclinicField.setText("");
                    doctorField.setText("");
                    dateField.setText("");
                    timeField.setText("");
                    appointmentAlert.setText("Hastaya ait randevu bulunamadı !");
                }else{
                    //polyclinicField.setText();
                    Appointment appointment = AppointmentController.findAppointmentByPatientId(Main.patientSearchData.getId());
                    polyclinicField.setText(appointment.getPolyclinic().getName());
                    doctorField.setText(appointment.getDoctor().getName() + " " + appointment.getDoctor().getSurname());
                    String dateValue =  " " + appointment.getDay() + " / " +  appointment.getMonth() + " / " + 2024;
                    dateField.setText(dateValue);
                    String timeValue = appointment.getHour() + " : " + appointment.getMinute();
                    timeField.setText(timeValue);
                    appointmentAlert.setText("");
                }
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {

            }
        });
    }

    /*
    public AppointmentRecordShow(){
        if(Main.data == null){
            AlertBox.ShowError(appointmentRecordShowPanel,"Hasta bilgisi çekilemedi !");
        }else{
            // find appointment with patient id
            System.out.println(Main.data);
        }
    }
    */
}
