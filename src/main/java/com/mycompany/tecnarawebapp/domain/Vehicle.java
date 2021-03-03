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
public class Vehicle {
    
    int id;
    String marca;
    String modelo;
    String matricula;
    int plazas;

    public Vehicle(int id, String marca, String modelo, String matricula, int plazas) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.plazas = plazas;
    }

    public Vehicle(String marca, String modelo, String matricula, int plazas) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.plazas = plazas;
    }
    
    public Vehicle(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.plazas = 5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
    
}
