package com.derman.views.doctor;

import com.derman.Main;
import com.derman.controller.DoctorController;
import com.derman.controller.PolyclinicController;
import com.derman.model.Doctor;
import com.derman.model.Polyclinic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorCreate {
    private JButton geriButton;
    private JTextField textName;
    private JTextField textphone;
    private JTextField textSurname;
    private JTextField textPolyclinic;
    private JButton kaydetButton;
    private JPanel doctorCreatePanel;
    private JTextField textUsername;
    private JTextField textPassword;
    private Polyclinic polyclinic;
    public DoctorCreate() {

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polyclinic = PolyclinicController.getPolyclinicbyName(textPolyclinic.getText());

                if (polyclinic != null) {
                    Doctor doctor = new Doctor(0,textUsername.getText(), textName.getText(),textSurname.getText()
                            ,textPassword.getText(), "doctor", textphone.getText(),polyclinic);
                    DoctorController.createDoctor(doctor);
                    JOptionPane.showMessageDialog(doctorCreatePanel, "Kayıt başarıyla oluşturuldu");
                    Main.goBack();
                }else{
                    JOptionPane.showMessageDialog(doctorCreatePanel, "Verilen isimle polikilinik bulunamadı!!");
                }


           }
        });



        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goBack();
            }
        });
    }

    public JPanel getDoctorCreatePanel() {
        return doctorCreatePanel;
    }
}
