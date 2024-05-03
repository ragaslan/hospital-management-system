package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Account;
import com.derman.model.ApplicationResponse;

import java.sql.SQLException;

public class AuthController {

    public static ApplicationResponse<Account> Login(String username, String password){
        // get db connection and authenticate user
        try(var connection = Db.connect()){
            Account user = AccountController.getAccountByUsername(username);
            if(user != null){
                if(user.getPassword().equals(password)){
                    return new ApplicationResponse<Account>(true,"Kullanıcı bulundu !",user);
                }else {
                    return new ApplicationResponse<Account>(false, "Girilen şifre hatalı", null);
                }
            }else{
                return new ApplicationResponse<Account>(false,"Girilen kullanıcı adı yanlış",null);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
            return new ApplicationResponse<Account>(false,"Giriş yaparken Sql exception hatası",null);
        }
    }



}
