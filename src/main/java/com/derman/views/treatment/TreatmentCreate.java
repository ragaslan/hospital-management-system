package com.derman.views.treatment;

import com.derman.Main;
import com.derman.controller.DoctorController;
import com.derman.controller.PatientController;
import com.derman.controller.TreatmentController;
import com.derman.model.Account;
import com.derman.model.Doctor;
import com.derman.model.Patient;
import com.derman.model.Treatment;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TreatmentCreate {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textEditComplaint;
    private JTextField textEditTests;
    private JTextField textEditDiagnosis;
    private JTextField textEditProspect;
    private JButton hastaKaydınıGörüntüleButton;
    private JButton kaydetButton;
    private JPanel treatmentCreatePanel;
    private Account account;
    private Doctor doctor;
    private Patient patient;

    public TreatmentCreate() {
        Treatment treatment = new Treatment();


        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                treatment.setPrescriptions(textEditProspect.getText());
                treatment.setTests(textEditTests.getText());
                treatment.setDiagnosis(textEditDiagnosis.getText());
                treatment.setPatient(Main.patientSearchData);
                treatment.setComplaint(textEditComplaint.getText());


                if(Main.patientSearchData == null){
                    AlertBox.ShowError(treatmentCreatePanel, "Bu TC numarası ile bir hasta bulunmuyor!!");
                }else{
                    try {
                        account = (Account) Main.data;
                        doctor = DoctorController.getDoctorById(account.getId());
                        treatment.setDoctor(doctor);

                        TreatmentController.createTreatment(treatment);
                        AlertBox.ShowError(treatmentCreatePanel, "Tedavi kaydı başarıyla oluşturuldu");
                    }catch (NullPointerException n){
                        AlertBox.ShowError(treatmentCreatePanel, "Bilinmeyen bir hata oluştu. hata : " + n.getMessage());
                    }
                }
            }
        });

        hastaKaydınıGörüntüleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("HastaGoster");
            }
        });

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Önceki sayfaya gitme
                Main.goBack();
            }
        });

    }

    public JPanel getTreatmentCreatePanel() {
        return treatmentCreatePanel;
    }
}
