package com.derman.views.menu;

import com.derman.Main;

import javax.swing.*;

public class ChiefDoctorMenu{
    private JButton profileButton;
    private JButton hastaKaydıGüncellemeButton;
    private JButton hastaKaydıGörüntülemeButton;
    private JButton tedaviKaydıOluşturmaButton;
    private JButton yeniPoliklinikKaydıButton;
    private JButton yeniDoktorKaydıButton1;
    private JPanel chiefDoctorMenuPanel;

    public ChiefDoctorMenu(){
        System.out.println(Main.data);
    }

    public JPanel getChiefDoctorMenuPanel() {
        return chiefDoctorMenuPanel;
    }

}
