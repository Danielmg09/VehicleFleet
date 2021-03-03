/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.service;

import com.mycompany.tecnarawebapp.dao.DAO;
import com.mycompany.tecnarawebapp.domain.Vehicle;
import java.util.List;

/**
 *
 * @author daniel
 */
public class VehicleService {
    DAO dao;
    
    public VehicleService(){
        dao = new DAO();
    }
    
    public List<Vehicle> getVehicles(){
        return dao.loadAllVehicles();
    }
    
    public String insertVehicle(String marca,String modelo, String matricula, int plazas){

        Vehicle vehicle = new Vehicle(marca, modelo, matricula, plazas);
        if (vehicle!= null){
            if(dao.insertVehicle(vehicle) == 1){
                return "vehiculo añadido";
            }else{
                return "no se ha podido añadir vehiculo";
            }
        }
        return "no se ha podido añadir vehiculo";
    } 
    
    public Vehicle deleteVehicle(int id){

        if(id!=-1){
            return dao.deleteVehicle(id);
        }
        return null;

    }
    
    public String updateVehicle(int id, String marca, String modelo, String matricula,int plazas){
        Vehicle vehicle = new Vehicle(id,marca,modelo,matricula, plazas);
        if (vehicle!=null){
            if (dao.updateVehicle(vehicle)==1){
                return "usuario modificado";
            }else{
                return "no se ha podido modificar";
            }
        }return "no se ha podido modificar";

    }
    
    public void printVehicle(Vehicle vehicle){
        System.out.println("id: "+ vehicle.getId());
        System.out.println("nmarca: "+ vehicle.getMarca());
        System.out.println("modelo: "+ vehicle.getModelo());
        System.out.println("matricula: "+ vehicle.getMatricula());
        System.out.println("plazas: "+vehicle.getPlazas());
        System.out.println("----------------------------------------------------------------------");

    }
    
    public Vehicle getVehicle(int id){
        return dao.getVehicle(id);
    }
    
    
    
     
    
}
