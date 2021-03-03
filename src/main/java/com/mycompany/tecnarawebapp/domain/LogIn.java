/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.domain;

/**
 *
 * @author daniel
 */
public class LogIn {
    
    boolean isLogged;
    String username;

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    public LogIn(boolean isLogged, String username) {
        this.isLogged = isLogged;
        this.username = username;
    }
    
    
    
    
    
}
