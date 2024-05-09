package com.derman.views.treatment;

import com.derman.Main;
import com.derman.controller.TreatmentController;
import com.derman.model.Treatment;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class InsuranceDetail {
    private JButton geriButton;
    private JTextField insuranceField;
    private JTextField priceField;
    private JButton getPaymentButton;
    private JPanel insuranceDetailPanel;

    public JPanel getInsuranceDetailPanel() {
        return insuranceDetailPanel;
    }


    public InsuranceDetail(){

        getPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlertBox.ShowError(insuranceDetailPanel,"Ödeme Başarıyla Tamamlandı Teşekkür Ederiz !");
                boolean result = TreatmentController.deleteTreatment(Main.patientSearchData.getId());
                if(result){
                    Main.patientSearchData = null;
                    Main.changeScreen("VeznedarMenu");
                }else{
                    System.out.println("silme hatası !");
                }
                System.out.println(result);
            }
        });

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goBack();
            }
        });

        insuranceDetailPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                if(Main.patientSearchData != null){
                    insuranceField.setText(Main.patientSearchData.getInsurance());
                    Treatment theTreatment = TreatmentController.getTreatmentByPatientId(Main.patientSearchData.getId());
                    int count = theTreatment.getTests().split(",").length;
                    priceField.setText(String.valueOf(count * 235));

                }
            }
        });
    }


}
