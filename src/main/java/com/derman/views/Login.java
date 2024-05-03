package com.derman.views;

import com.derman.model.ApplicationResponse;
import com.derman.controller.AuthController;
import com.derman.model.Account;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setLocationRelativeTo(null);
        setTitle("Giriş Yap");
        setVisible(true);


        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = usernameField.getText().trim();
                String password = String.valueOf(passwordField.getPassword()).trim();

                if(username.isEmpty() || password.isEmpty()){
                    AlertBox.ShowError(loginMainPanel,"Şifre ve kullanıcı adı eksik olamaz");
                }else{
                    ApplicationResponse<Account> response = AuthController.Login(username,password);
                    if(response.getSuccess()){
                        //AlertBox.ShowError(loginMainPanel,response.getMessage());
                        // go to other screen with response data
                        System.out.println(response.getData());
                    }else{
                        AlertBox.ShowError(loginMainPanel,response.getMessage());
                    }
                }

            }
        });


    }

}
