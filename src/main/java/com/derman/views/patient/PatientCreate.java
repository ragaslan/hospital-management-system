package com.derman.views.patient;

import com.derman.Main;
import com.derman.controller.DoctorController;
import com.derman.controller.PatientController;
import com.derman.controller.TreatmentController;
import com.derman.model.Account;
import com.derman.model.Patient;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientCreate {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textEditName;
    private JTextField textEditTc;
    private JTextField textEditSurname;
    private JTextField textEditBloodGroup;
    private JButton kaydetButton;
    private JPanel patientCreatePanel;
    private JTextField textEditPhone;
    private JTextField textEditAddress;

    public PatientCreate() {
        Patient patient = new Patient();

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patient.setName(textEditName.getText());
                patient.setSurname(textEditSurname.getText());
                patient.setAddress(textEditAddress.getText());
                patient.setPhone(textEditPhone.getText());
                patient.setBlood(textEditBloodGroup.getText());
                patient.setTc(textEditTc.getText());

                if (patient.getTc().equals("") && patient.getSurname().equals("") &&
                        patient.getBlood().equals("") && patient.getPhone().equals("") && patient.getName().equals("")){
                    AlertBox.ShowError(patientCreatePanel, "* ile belirtilen alanlar doldurulmak zorundadır!!!");
                }else {
                    try {
                        PatientController.createPatient(patient);
                        AlertBox.ShowError(patientCreatePanel, "Hasta kaydı başarıyla oluşturuldu");
                    }catch (NullPointerException n){
                        AlertBox.ShowError(patientCreatePanel, "Bilinmeyen bir hata oluştu. hata : " + n.getMessage());
                    }
                }
            }
        });


        profilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //data'daki kullanıcıyı sil
                Main.data = null;
                Main.visitedPages.pop();
                Main.changeScreen("Giris");
            }
        });

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.visitedPages.pop();
                Main.changeScreen(Main.visitedPages.lastElement());
            }
        });
    }

    public JPanel getPatientCreatePanel() {
        return patientCreatePanel;
    }
}
