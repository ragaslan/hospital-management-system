package com.derman.views.polyclinic;

import com.derman.Main;
import com.derman.controller.PolyclinicController;
import com.derman.model.Polyclinic;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolyclinicCreate {
    private JButton geriButton;
    private JTextField textField1;
    private JButton kaydetButton;
    private JPanel polyclinicCreatePanel;

    public PolyclinicCreate() {
        Polyclinic polyclinic = new Polyclinic();

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polyclinic.setName(textField1.getText());
                PolyclinicController.createPolyclinic(polyclinic);
                AlertBox.ShowError(polyclinicCreatePanel, "Poliklinik oluşturuldu");
            }
       });

        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goBack();
            }
        });
    }

    public JPanel getPolyclinicCreatePanel() {
        return polyclinicCreatePanel;
    }
}
