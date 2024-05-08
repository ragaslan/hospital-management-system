package com.derman.views.menu;

import com.derman.Main;
import com.derman.model.Account;

import javax.swing.*;
import java.awt.event.*;

public class AppointmentAttendantMenu {

    private JButton profileButton;
    private JButton searchAppointmentRecordButton;
    private JButton seeAppointmentCalenderButton;
    private JPanel AppointmentAttendantPanel;
    private Account currentAccount;

    public AppointmentAttendantMenu() {

        seeAppointmentCalenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.changeScreen("RandevuEkrani");
            }
        });

        searchAppointmentRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Main.visitedPages.push("RandevuKayitGoster");
                Main.afterPatientSearch = "RandevuKayitGoster";
                Main.changeScreen("HastaAra");
            }
        });


        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //data'daki kullanıcıyı sil
                Main.data = null;
                Main.visitedPages.clear();
                Main.changeScreen("Giris");
            }
        });

        //Compenent görünür olduğunda trigger'lanır
        ComponentListener componentListener = new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                currentAccount = (Account)Main.data;
                profileButton.setText(currentAccount.getUsername() + " : Çıkış Yap");
            }
        };
        AppointmentAttendantPanel.addComponentListener(componentListener);
        AppointmentAttendantPanel.addComponentListener(new ComponentAdapter() {
        });


    }

    public JPanel getAppointmentAttendantPanel() {
        return AppointmentAttendantPanel;
    }

}
