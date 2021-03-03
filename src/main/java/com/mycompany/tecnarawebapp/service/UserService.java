/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.service;

import com.mycompany.tecnarawebapp.dao.DAO;
import com.mycompany.tecnarawebapp.dao.DaoUsers;
import com.mycompany.tecnarawebapp.domain.User;
import java.util.List;

/**
 *
 * @author daniel
 */
public class UserService {
    
    DaoUsers dao;
    
    public UserService(){
        dao = new DaoUsers();
    }
    
    
    
    public List<User> getUsersList(){
        return dao.getUsersList();
    }
    
    public boolean authenticateUser(String username, String password){
        return dao.checkUser(username, password);
     
    }
    
    
    
}
