package com.derman.views.menu;

import com.derman.Main;
import com.derman.controller.PatientController;
import com.derman.model.Account;
import com.derman.model.Patient;

import javax.swing.*;
import java.awt.event.*;

public class ChiefDoctorMenu{
    private JButton profileButton;
    private JButton hastaKaydıGüncellemeButton;
    private JButton hastaKaydıGörüntülemeButton;
    private JButton tedaviKaydıOluşturmaButton;
    private JButton yeniPoliklinikKaydıButton;
    private JButton yeniDoktorKaydıButton1;
    private JPanel chiefDoctorMenuPanel;
    private Account currentAccount;

    public ChiefDoctorMenu(){

        hastaKaydıGüncellemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.afterPatientSearch = "HastaGuncelle";
                Main.changeScreen("HastaAra");
            }
        });

        hastaKaydıGörüntülemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.afterPatientSearch = "HastaGoster";
                Main.changeScreen("HastaAra");
            }
        });

        tedaviKaydıOluşturmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.afterPatientSearch = "TedaviOlustur";
                Main.changeScreen("HastaAra");
            }
        });

        yeniPoliklinikKaydıButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("PoliklinikOlustur");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //data'daki kullanıcıyı sil
                Main.data = null;
                Main.visitedPages.pop();
                Main.changeScreen("Giris");
            }
        });



        //Compenent görünür olduğunda trigger'lanır
        ComponentListener componentListener = new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                currentAccount = (Account) Main.data;
                profileButton.setText(currentAccount.getUsername() + " : Çıkış Yap");
            }
        };
        chiefDoctorMenuPanel.addComponentListener(componentListener);

    }

    public JPanel getChiefDoctorMenuPanel() {
        return chiefDoctorMenuPanel;
    }

}
