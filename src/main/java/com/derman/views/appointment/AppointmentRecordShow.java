package com.derman.views.appointment;

import com.derman.Main;
import com.derman.model.Patient;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AppointmentRecordShow {
    private JButton profileButton;
    private JButton geriButton;
    private JButton createPatientButton;
    private JPanel appointmentRecordShowPanel;
    private JTextField polyclinicField;
    private JTextField doctorField;
    private JTextField dateField;
    private JTextField timeField;

    public JPanel getAppointmentRecordShowPanel() {
        return appointmentRecordShowPanel;
    }


    public AppointmentRecordShow(){
        appointmentRecordShowPanel.addComponentListener(new ComponentListener() {


            @Override
            public void componentResized(ComponentEvent componentEvent) {

            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {

            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                Patient patient = (Patient)Main.data;
                // find appointment with patient id

                if( (Patient)Main.data == null){
                    System.out.println("Veri gelmedi");
                }else{
                    //polyclinicField.setText();
                    System.out.println("veri geldi");
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
