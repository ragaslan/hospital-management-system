package com.derman.controller;

import com.derman.database.Db;

import java.sql.Connection;

public class AuthController {

    public void Login(String username,String password){
        // get db connection and authenticate user

        Db db = new Db();
        Connection con = db.createConnection();


    }



}
