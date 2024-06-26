package com.derman.views.patient;

import com.derman.Main;
import com.derman.controller.PatientController;
import com.derman.model.Patient;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

import static com.derman.controller.PatientController.getPatientbyTC;

public class PatientUpdate {
    private JButton geriButton;
    private JTextField textAd;
    private JTextField textKnownI;
    private JTextField textTc;
    private JTextField textaddress;
    private JTextField textSoyad;
    private JTextField textTelNo;
    private JTextField textBlood;
    private JTextField textAlergies;
    private JButton bilgileriGüncelleButton;
    private JPanel patientUpdatePanel;
    private Patient patient;

    public PatientUpdate() {

        ComponentListener componentListener = new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                patient = Main.patientSearchData;
                System.out.println(patient.getPhone());
                if(patient != null){
                    textAd.setText(patient.getName());
                    textSoyad.setText(patient.getSurname());
                    textTc.setText(patient.getTc());
                    textTelNo.setText(patient.getPhone());
                    textaddress.setText(patient.getAddress());
                    textBlood.setText(patient.getBlood());
                    textAlergies.setText(patient.getAlergies());
                    textKnownI.setText(patient.getDiseases());
                }else{
                    textAd.setText("");
                    textSoyad.setText("");
                    textTc.setText("");
                    textTelNo.setText("");
                    textaddress.setText("");
                    textBlood.setText("");
                    textAlergies.setText("");
                    textKnownI.setText("");
                }
            }
        };
        patientUpdatePanel.addComponentListener(componentListener);


        bilgileriGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patient.setName(textAd.getText());
                patient.setSurname(textSoyad.getText());
                patient.setTc(textTc.getText());
                patient.setAddress(textaddress.getText());
                patient.setBlood(textBlood.getText());
                patient.setAlergies(textAlergies.getText());
                patient.setDiseases(textKnownI.getText());
                patient.setPhone(textTelNo.getText());

                PatientController.updatePatient(patient);
                AlertBox.ShowError(patientUpdatePanel, "Hasta bilgisi başarıyla güncellendi");
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

    public JPanel getPatientUpdatePanel() {
        return patientUpdatePanel;
    }
}
