package com.derman.views.menu;

import com.derman.Main;
import com.derman.model.Account;

import javax.swing.*;
import java.awt.event.*;

public class DoctorMenu {
    private JButton profileButton;
    private JButton hastaKaydıGüncellemeButton;
    private JButton hastaKaydıGörüntülemeButton;
    private JButton tedaviKaydıOluşturmaButton;
    private JPanel doctorMenuPanel;
    private Account currentAccount;

    public DoctorMenu() {
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

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //data'daki kullanıcıyı sil
                Main.data = null;
                Main.visitedPages.pop();
                Main.changeScreen("Giris");
            }
        });

        tedaviKaydıOluşturmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.afterPatientSearch = "TedaviOlustur";
                Main.changeScreen("HastaAra");
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
        doctorMenuPanel.addComponentListener(componentListener);
    }

    public JPanel getDoctorMenuPanel() {
        return doctorMenuPanel;
    }

}
