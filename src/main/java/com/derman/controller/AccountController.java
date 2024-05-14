package com.derman.controller;

import com.derman.database.Db;
import com.derman.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountController {

    // CRUD SQL OPERATIONS FOR account MODEL

    // get single account with username
    public static Account getAccountById(int id){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from account where id = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setInt(1,id);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    Account user = new Account(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("name"),
                                resultSet.getString("phone"),
                                resultSet.getString("surname"),
                                resultSet.getString("password"),
                                resultSet.getString("role")
                    );
                    return user;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static Account getAccountByUsername(String username){
        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from account where username = ?";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                stmt.setString(1,username);
                ResultSet resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    Account user = new Account(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("phone"),
                            resultSet.getString("password"),
                            resultSet.getString("role")
                    );
                    return user;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }


    // get ALL account
    public static List<Account> getAll(){
        List<Account> accountList = new ArrayList<Account>();

        try(var connection = Db.connect()){
            if (connection != null){
                String selectSql = "select * from account";
                PreparedStatement stmt = connection.prepareStatement(selectSql);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    accountList.add(new Account(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("phone"),
                            resultSet.getString("password"),
                            resultSet.getString("role")
                    ));
                }
                return accountList;
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        return null;
    }



    // create a account

    // delete a account

}
