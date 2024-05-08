package com.derman.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static final String url = "jdbc:postgresql://localhost:5432/derman";
    private static final String username = "postgres";
    private static final String password = "12345";

    public static Connection connect() throws SQLException {
        try{
            // open a connection
            return DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }








}
