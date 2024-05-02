package com.derman.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "postgres";

    private Connection connection;

    public Connection createConnection(){
        try{
            connection = DriverManager.getConnection(url,username,password);
            if(connection != null){
                System.out.println("Db Bağlantısı Başarılı !");
            }
            return connection;
        }catch (SQLException err){
            System.out.println("Db Bağlantı Hatası !");
            System.out.println(err.getMessage());
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try{
            connection.close();
        }catch (SQLException err){
            System.out.println("Db Bağlantı Kapatma Hatası !");
            System.out.println(err.getMessage());
        }
    }

}
