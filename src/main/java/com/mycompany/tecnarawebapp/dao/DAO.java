/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.dao;

import com.mycompany.tecnarawebapp.domain.User;
import com.mycompany.tecnarawebapp.domain.Vehicle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author daniel
 */
public class DAO {
    
    Connection conexion;
    
    public DAO(){
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
    
    public List<Vehicle> loadAllVehicles(){
        try{
            List<Vehicle> vehicles = new ArrayList<>();
            String sql = "SELECT * FROM vehiculos";
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Vehicle v = new Vehicle (rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("matricula"),
                        rs.getInt("plazas"));
                vehicles.add(v);
            }
            statement.close();
            return vehicles;

        }catch (SQLException ex) {
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Vehicle filtrarPorId(int id, List<Vehicle> vehicles){
        
        for (Vehicle vehiculo : vehicles){
            if(vehiculo.getId()==id){
                return vehiculo;
            }
        }return null;

        
    }
    
    public int insertVehicle(Vehicle vehicle) {

        String sql = "INSERT INTO vehiculos (marca, modelo, matricula,plazas) " +
                "VALUES ('"+vehicle.getMarca()+
                "','"+vehicle.getModelo()+
                "','"+vehicle.getMatricula()+
                "','"+vehicle.getPlazas()+"')";

        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return 1;

        }catch(SQLException ex){
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return 0;
        }

    }

    public Vehicle deleteVehicle(int id){
        List<Vehicle> vehiculos = loadAllVehicles();
        Vehicle vehicle = filtrarPorId(id,vehiculos);
        String sql = "DELETE FROM vehiculos WHERE id = '"+id+"'";
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return vehicle;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

    public int updateVehicle(Vehicle vehicle) {
       

        String sql = "UPDATE vehiculos SET marca = '" +vehicle.getMarca()+"'" +
                ", modelo = '" +vehicle.getModelo()+"'" +
                ", matricula = '" +vehicle.getMatricula()+"'" +
                ", plazas = '" +vehicle.getPlazas()+ "'" +
                " WHERE id = '"+vehicle.getId()+"'";

        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return 1;

        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }

    }
    
    public Vehicle getVehicle(int id){
        Vehicle vehicle = null;
        try{
            
            String sql = "SELECT * FROM vehiculos WHERE id='"+id+"'";
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()){
                vehicle = new Vehicle (rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("matricula"),
                        rs.getInt("plazas"));
            }
            statement.close();
            return vehicle;

        }catch (SQLException ex) {
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }finally{
            return vehicle;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
