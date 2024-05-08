package com.derman.views.appointment;

import com.derman.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentCalender {
    private JButton profilButton;
    private JButton geriButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JButton randevuOluşturButton;
    private JList list5;
    private JPanel appointmentCalenderPanel;

    public AppointmentCalender() {
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.visitedPages.pop();
                Main.changeScreen(Main.visitedPages.lastElement());
            }
        });
    }

    public JPanel getAppointmentCalenderPanel() {
        return appointmentCalenderPanel;
    }
}
