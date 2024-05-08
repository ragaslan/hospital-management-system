package com.derman.views.treatment;

import com.derman.Main;
import com.derman.controller.DoctorController;
import com.derman.controller.PatientController;
import com.derman.controller.TreatmentController;
import com.derman.model.Account;
import com.derman.model.Doctor;
import com.derman.model.Patient;
import com.derman.model.Treatment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TreatmentCreate {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField4;
    private JButton hastaKaydınıGörüntüleButton;
    private JButton kaydetButton;
    private JPanel treatmentCreatePanel;
    private JComboBox comboBox1;
    private Account account;
    private Doctor doctor;
    private Patient patient;

    public TreatmentCreate() {
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account = (Account) Main.data;
                doctor = DoctorController.getDoctorById(doctor.getId());

                Treatment treatment = new Treatment(1, doctor , patient,"comp", "tests", "diagno", "prep");
                Account currentAccount = (Account) Main.data;
                TreatmentController.createTreatment(treatment, currentAccount.getId());
                //Önceki sayfaya gitme
                Main.visitedPages.pop();
                Main.changeScreen(Main.visitedPages.lastElement());
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


    }

    public JPanel getTreatmentCreatePanel() {
        return treatmentCreatePanel;
    }
}
