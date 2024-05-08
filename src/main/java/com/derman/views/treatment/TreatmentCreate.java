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
    private JComboBox comboBox1;
    private Account account;
    private Doctor doctor;
    private Patient patient;

    public TreatmentCreate() {
        List<String> TcList = new ArrayList<String>();
        TcList = PatientController.getAllTcNumbers();
        Treatment treatment = new Treatment();

        if (TcList != null) {
            for (String tc : TcList) {
                comboBox1.addItem(tc);
            }
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the combo box
                patient = PatientController.getPatientbyTC(comboBox1.getSelectedItem().toString());
            }
        });

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                treatment.setPrescriptions(textEditProspect.getText());
                treatment.setTests(textEditTests.getText());
                treatment.setDiagnosis(textEditDiagnosis.getText());
                treatment.setPatient(patient);
                treatment.setComplaint(textEditComplaint.getText());
                treatment.setDoctor(doctor);

                if(comboBox1.getSelectedItem() == null){
                    AlertBox.ShowError(treatmentCreatePanel, "Bir TC kimlik numarası seçiniz!!");
                }else{
                    try {
                        account = (Account) Main.data;
                        doctor = DoctorController.getDoctorById(account.getId());
                        TreatmentController.createTreatment(treatment);
                        AlertBox.ShowError(treatmentCreatePanel, "Tedavi kaydı başarıyla oluşturuldu");
                    }catch (NullPointerException n){
                        AlertBox.ShowError(treatmentCreatePanel, "Bilinmeyen bir hata oluştu. hata : " + n.getMessage());
                    }
                }
            }
        });

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
