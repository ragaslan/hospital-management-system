package com.derman.views.menu;

import com.derman.Main;
import com.derman.model.Account;

import javax.swing.*;
import java.awt.event.*;

public class RegistrarMenu {
    private JButton profileButton;
    private JButton hastaKaydıGörüntülemeButton;
    private JButton randevuKaydıGörüntülemeButton;
    private JPanel registrarMenuPanel;
    private JButton registerPatientButton;
    private Account currentAccount;

    public RegistrarMenu() {

        registerPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("HastaOlustur");
            }
        });

        hastaKaydıGörüntülemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("HastaGoster");
            }
        });

        randevuKaydıGörüntülemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("RandevuKayitGoster");
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
        registrarMenuPanel.addComponentListener(componentListener);
    }

    public JPanel getRegistrarMenuPanel() {
        return registrarMenuPanel;
    }
}
