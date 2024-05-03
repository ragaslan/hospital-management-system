package com.derman.views.alerts;

import javax.swing.*;

public class AlertBox {
    public static void ShowError(JPanel panel,String errMessage){
        JOptionPane.showMessageDialog(panel, errMessage);
    }
}
