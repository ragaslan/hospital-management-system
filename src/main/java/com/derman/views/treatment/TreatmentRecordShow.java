package com.derman.views.treatment;

import com.derman.Main;
import com.derman.controller.TreatmentController;
import com.derman.model.Patient;
import com.derman.model.Treatment;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TreatmentRecordShow {
    private JButton geriButton;
    private JTextField diagnosisField;
    private JTextField testField;
    private JButton insuranceDetailButton;
    private JPanel treatmentRecordShowPanel;

    public TreatmentRecordShow(){
        insuranceDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("SigortaDetay");
            }
        });
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goBack();
            }
        });


        treatmentRecordShowPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                if(Main.patientSearchData != null){
                    Treatment theTreatment = TreatmentController.getTreatmentByPatientId(Main.patientSearchData.getId());
                    if(theTreatment == null){
                        testField.setText("");
                        diagnosisField.setText("");
                        AlertBox.ShowError(treatmentRecordShowPanel,"Tedavi kaydı bulunamadı !");
                        Main.goBack();
                    }else{
                        //System.out.println(theTreatment.toString());
                        testField.setText(theTreatment.getTests());
                        diagnosisField.setText(theTreatment.getDiagnosis());
                    }
                }
            }
        });


    }

    public JPanel getTreatmentRecordShowPanel() {
        return treatmentRecordShowPanel;
    }
}
