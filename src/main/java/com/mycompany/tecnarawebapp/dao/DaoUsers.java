/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.dao;

import com.mycompany.tecnarawebapp.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class DaoUsers {

    private Connection conexion;
    
    public DaoUsers(){
        try {
            String url ="jdbc:mysql://127.0.0.1:3306/vehiculos" ;
            String url2 = "jdbc:mysql://localhost:3306/vehiculos?serverTimezone=" + TimeZone.getDefault().getID();
            String user = "root";
            String password = "Administrator";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url2,user,password);
            System.out.println("Conectado");

        }catch(SQLException | ClassNotFoundException ex){
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
    
    public List<User> getUsersList(){
        try{
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM usuarios";
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                User u = new User (rs.getString("user"),
                        rs.getString("password"));
                users.add(u);
            }
            statement.close();
            return users;

        }catch (SQLException ex) {
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean checkUser(String username, String password){
        String sql = "SELECT * FROM usuarios WHERE user LIKE '"+username+"' AND password LIKE '"+password+"' ";
            Statement statement;
        try {
            statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                return true;
            }
            
             
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        
        return false;
        
    }
    
}
