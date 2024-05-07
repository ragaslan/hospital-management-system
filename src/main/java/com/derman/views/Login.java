package com.derman.views;

import com.derman.Main;
import com.derman.model.ApplicationResponse;
import com.derman.controller.AuthController;
import com.derman.model.Account;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login{

    private JButton loginBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel loginContentPanel;
    private JLabel titleLabel;

    public JPanel getLoginContentPanel(){
        return loginContentPanel;
    }


    public Login(){
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = usernameField.getText().trim();
                String password = String.valueOf(passwordField.getPassword()).trim();

                if(username.isEmpty() || password.isEmpty()){
                    AlertBox.ShowError(loginContentPanel,"Şifre ve kullanıcı adı eksik olamaz");
                }else{
                    ApplicationResponse<Account> response = AuthController.Login(username,password);
                    if(response.getSuccess()){
                        // go to other screen with response data
                        if(response.getData() != null){
                            Main.data = response.getData();
                            switch (response.getData().getRole()){
                                case "bashekim":
                                    Main.changeScreen("BasHekimMenu");
                                    break;
                                case "doktor":
                                    Main.changeScreen("DoktorMenu");
                                    break;
                                case "randevugorevlisi":
                                    Main.changeScreen("RandevuGorevlisiMenu");
                                    break;
                                case "kayitgorevlisi":
                                    Main.changeScreen("KayitGorevlisiMenu");
                                    break;
                                case "veznedar":
                                    Main.changeScreen("VeznedarMenu");
                                    break;
                            }
                        }
                    }else{
                        AlertBox.ShowError(loginContentPanel,response.getMessage());
                    }
                }

            }
        });
    }
}
