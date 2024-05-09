package com.derman.views.patient;

import com.derman.Main;
import com.derman.model.Patient;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;

import static com.derman.controller.PatientController.getPatientbyTC;

public class PatientShow {
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
    private Patient patient;

    public PatientShow() {


        ComponentListener componentListener = new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                patient = Main.patientSearchData;

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
        };
        patientShowPanel.addComponentListener(componentListener);


        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Önceki sayfaya gitme
                Main.goBack();
            }
        });



    }



    public JPanel getPatientShowPanel() {
        return patientShowPanel;
    }
}
