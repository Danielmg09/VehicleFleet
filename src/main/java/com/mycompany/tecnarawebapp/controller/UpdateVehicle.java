/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.controller;

import com.mycompany.tecnarawebapp.domain.Vehicle;
import com.mycompany.tecnarawebapp.service.VehicleService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel
 */
public class UpdateVehicle extends HttpServlet {
    
      VehicleService vehicleService = new VehicleService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vehicle vehicle = vehicleService.getVehicle(Integer.parseInt(request.getParameter("id")));
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("id", vehicle.getId());
        mySession.setAttribute("marca", vehicle.getMarca());
        mySession.setAttribute("modelo", vehicle.getModelo());
        mySession.setAttribute("matricula", vehicle.getMatricula());
        mySession.setAttribute("plazas", vehicle.getPlazas());
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateVehicle.jsp");
        rd.forward(request, response);

    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String matricula = request.getParameter("matricula");
        int plazas = Integer.parseInt(request.getParameter("plazas"));
        
        vehicleService.updateVehicle(id, marca, modelo, matricula,plazas);
        
        List<Vehicle> vehiculos = vehicleService.getVehicles();
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("vehiculos",vehiculos);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listAll.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
