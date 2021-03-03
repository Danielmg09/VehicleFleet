/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnarawebapp.controller;

import com.mycompany.tecnarawebapp.domain.LogIn;
import com.mycompany.tecnarawebapp.domain.User;

import com.mycompany.tecnarawebapp.service.UserService;

import java.io.IOException;

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
public class Login extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();

        String username = request.getParameter("user");
        String password = request.getParameter("password");

        
        boolean isLogged = userService.authenticateUser(username,password);

        HttpSession mySession = request.getSession(true);
        RequestDispatcher rd = null;

        if (isLogged) {

            LogIn logIn = new LogIn(isLogged, username);
            mySession.setAttribute("login", logIn);
            mySession.setAttribute("loginError", null);

            response.sendRedirect("/tecnaraWebapp/vehicle/listAll");

        } else {
            mySession.setAttribute("loginError", "credenciales invalidas");
            doGet(request, response);
        }

       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
