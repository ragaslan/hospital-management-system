package com.derman.views.menu;

import com.derman.Main;
import com.derman.controller.PatientController;
import com.derman.model.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChiefDoctorMenu{
    private JButton profileButton;
    private JButton hastaKaydıGüncellemeButton;
    private JButton hastaKaydıGörüntülemeButton;
    private JButton tedaviKaydıOluşturmaButton;
    private JButton yeniPoliklinikKaydıButton;
    private JButton yeniDoktorKaydıButton1;
    private JPanel chiefDoctorMenuPanel;
    private Patient patient;

    public ChiefDoctorMenu(){
        hastaKaydıGüncellemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("HastaGuncelle");
            }
        });

    }

    public JPanel getChiefDoctorMenuPanel() {
        return chiefDoctorMenuPanel;
    }

}
