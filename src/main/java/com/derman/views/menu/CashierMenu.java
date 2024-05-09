package com.derman.views.menu;

import com.derman.Main;
import com.derman.model.Account;

import javax.swing.*;
import java.awt.event.*;

public class CashierMenu {
    private JButton profileButton;
    private JButton tedaviKaydıGörüntüleButton;
    private JPanel cashierMenuPanel;
    private Account currentAccount;

    public CashierMenu() {
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //data'daki kullanıcıyı sil
                Main.data = null;
                Main.visitedPages.pop();
                Main.changeScreen("Giris");
            }
        });

        tedaviKaydıGörüntüleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen("TedaviKaydiGoster");
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
        cashierMenuPanel.addComponentListener(componentListener);
    }

    public JPanel getCashierMenuPanel() {
        return cashierMenuPanel;
    }
}
