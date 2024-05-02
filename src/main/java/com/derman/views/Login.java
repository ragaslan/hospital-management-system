package com.derman.views;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    private JPanel loginMainPanel;
    private JButton loginBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel loginContentPanel;
    private JLabel titleLabel;

    public Login(){
        setContentPane(loginMainPanel);
        setMinimumSize(new Dimension(500,500));
        setTitle("Giriş Yap");
        setVisible(true);
    }

}
