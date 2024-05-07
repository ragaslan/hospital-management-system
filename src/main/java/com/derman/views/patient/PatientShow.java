package com.derman.views.patient;

import com.derman.Main;
import com.derman.model.Patient;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.derman.controller.PatientController.getPatientbyTC;

public class PatientShow {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textEditName;
    private JTextField textEditTc;
    private JTextField textEditAdrress;
    private JTextField textEditKnownIllness;
    private JTextField textEditSurname;
    private JTextField textEditPhoneNo;
    private JTextField textEditBloodGroup;
    private JTextField textEditAllergies;
    private JPanel patientShowPanel;
    private JTextField PatientTc;
    private Patient patient;

    public PatientShow() {

        DocumentListener textListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                patient = getPatientbyTC(PatientTc.getText());
                if(patient != null){
                    textEditName.setText(patient.getName());
                    textEditSurname.setText(patient.getSurname());
                    textEditTc.setText(patient.getTc());
                    textEditPhoneNo.setText(patient.getPhone());
                    textEditAdrress.setText(patient.getAddress());
                    textEditBloodGroup.setText(patient.getBlood());
                    textEditAllergies.setText(patient.getAlergies());
                    textEditKnownIllness.setText(patient.getDiseases());
                }else{
                    textEditName.setText("");
                    textEditSurname.setText("");
                    textEditTc.setText("");
                    textEditPhoneNo.setText("");
                    textEditAdrress.setText("");
                    textEditBloodGroup.setText("");
                    textEditAllergies.setText("");
                    textEditKnownIllness.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                patient = getPatientbyTC(PatientTc.getText());
                if(patient != null){
                    textEditName.setText(patient.getName());
                    textEditSurname.setText(patient.getSurname());
                    textEditTc.setText(patient.getTc());
                    textEditPhoneNo.setText(patient.getPhone());
                    textEditAdrress.setText(patient.getAddress());
                    textEditBloodGroup.setText(patient.getBlood());
                    textEditAllergies.setText(patient.getAlergies());
                    textEditKnownIllness.setText(patient.getDiseases());
                }else{
                    textEditName.setText("");
                    textEditSurname.setText("");
                    textEditTc.setText("");
                    textEditPhoneNo.setText("");
                    textEditAdrress.setText("");
                    textEditBloodGroup.setText("");
                    textEditAllergies.setText("");
                    textEditKnownIllness.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) { }
        };
        PatientTc.getDocument().addDocumentListener(textListener);

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Önceki sayfaya gitme
                Main.visitedPages.pop();
                Main.changeScreen(Main.visitedPages.lastElement());
            }
        });

    }



    public JPanel getPatientShowPanel() {
        return patientShowPanel;
    }
}
