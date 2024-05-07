package com.derman.views.patient;

import com.derman.Main;
import com.derman.model.Patient;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.derman.controller.PatientController.getPatientbyTC;

public class PatientUpdate {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textAd;
    private JTextField textKnownI;
    private JTextField textId;
    private JTextField textaddress;
    private JTextField textSoyad;
    private JTextField textTelNo;
    private JTextField textBlood;
    private JTextField textAlergies;
    private JButton bilgileriGüncelleButton;
    private JPanel patientUpdatePanel;
    private JLabel tc_label;
    private JTextField patientTc;
    private Patient patient;

    public PatientUpdate() {

        DocumentListener textListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                patient = getPatientbyTC(patientTc.getText());
                System.out.println(patient);
                if(patient != null){
                    textAd.setText(patient.getName());
                    textSoyad.setText(patient.getSurname());
                    textId.setText(Integer.toString(patient.getId()));
                    textTelNo.setText(patient.getPhone());
                    textaddress.setText(patient.getAddress());
                    textBlood.setText(patient.getBlood());
                    textAlergies.setText(patient.getAlergies());
                    textKnownI.setText(patient.getDiseases());
                }else{
                    textAd.setText("");
                    textSoyad.setText("");
                    textId.setText("");
                    textTelNo.setText("");
                    textaddress.setText("");
                    textBlood.setText("");
                    textAlergies.setText("");
                    textKnownI.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                patient = getPatientbyTC(patientTc.getText());
                System.out.println(patient);
                if(patient != null){
                    textAd.setText(patient.getName());
                    textSoyad.setText(patient.getSurname());
                    textId.setText(Integer.toString(patient.getId()));
                    textTelNo.setText(patient.getPhone());
                    textaddress.setText(patient.getAddress());
                    textBlood.setText(patient.getBlood());
                    textAlergies.setText(patient.getAlergies());
                    textKnownI.setText(patient.getDiseases());
                }else{
                    textAd.setText("");
                    textSoyad.setText("");
                    textId.setText("");
                    textTelNo.setText("");
                    textaddress.setText("");
                    textBlood.setText("");
                    textAlergies.setText("");
                    textKnownI.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) { }
        };
        patientTc.getDocument().addDocumentListener(textListener);

        bilgileriGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public JPanel getPatientUpdatePanel() {
        return patientUpdatePanel;
    }
}
