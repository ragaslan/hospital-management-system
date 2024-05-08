package com.derman.views.treatment;

import com.derman.controller.PatientController;

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
    private List<String> TcList = new ArrayList<String>();

    public TreatmentCreate() {
        profilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TcList = PatientController.getAllTcNumbers();
                System.out.println(TcList);
            }
        });
    }

    public JPanel getTreatmentCreatePanel() {
        return treatmentCreatePanel;
    }
}
