package com.derman.views.patient;

import com.derman.Main;
import com.derman.model.Patient;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.derman.controller.PatientController.getPatientbyTC;

public class PatientSearch {
    private JButton geriButton;
    private JTextField textField1;
    private JButton hastayıBulButton;
    private JPanel patientSearchPanel;
    private Patient patient;
    private String lastPage;

    public PatientSearch() {

        //Tam olarak çalışmıyor. Hasta aranan ekranlarda değişiklik yapılacak
        hastayıBulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isEmpty()){
                    AlertBox.ShowError(patientSearchPanel,"Hasta TC kimlik numarası boş bırakılamaz");
                }else{
                    patient = getPatientbyTC(textField1.getText());
                    if(patient != null){
                        AlertBox.ShowError(patientSearchPanel,"Hasta kaydı bulundu!");
                        Main.patientSearchData = patient;
                        Main.visitedPages.pop();
                        if(!Main.afterPatientSearch.isEmpty()){
                            String goTo = Main.afterPatientSearch;
                            Main.afterPatientSearch = "";
                            Main.changeScreen(goTo);
                            return;
                        }
                        lastPage = Main.visitedPages.lastElement();
                        Main.changeScreen(lastPage);
                    }else {
                        AlertBox.ShowError(patientSearchPanel,"Hasta kaydı bulunamadı!!");
                    }

                }
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

    public JPanel getPatientSearchPanel() {
        return patientSearchPanel;
    }
}
