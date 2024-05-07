package com.derman.views.menu;

import com.derman.Main;
import com.derman.model.Account;

import javax.swing.*;
import java.awt.event.*;

public class AppointmentAttendantMenu {

    private JButton profileButton;
    private JButton randevuKaydıGörüntülemeButton;
    private JButton randevuMüsaitlikGörüntülemeButton;
    private JButton randevuKaydıOluşturmaButton;
    private JPanel AppointmentAttendantPanel;
    private Account currentAccount;

    public AppointmentAttendantMenu() {
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
        AppointmentAttendantPanel.addComponentListener(componentListener);
    }

    public JPanel getAppointmentAttendantPanel() {
        return AppointmentAttendantPanel;
    }

}
