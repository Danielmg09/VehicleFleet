<%-- 
    Document   : listAll
    Created on : 07-oct-2020, 10:38:48
    Author     : daniel
--%>

<%@page import="com.mycompany.tecnarawebapp.domain.LogIn"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.tecnarawebapp.domain.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="layout/menu.jspf" %>
        <h1>Lista de vehiculos</h1>
        
        <% HttpSession mySession = request.getSession(false);
        List<Vehicle> vehiculos = (List<Vehicle>)mySession.getAttribute("vehiculos");
        LogIn logIn = (LogIn)mySession.getAttribute("login");
        
        %>
        
        
        <table border>
            <td><strong>Id</strong></td>
            <td><strong>Marca</strong></td>
            <td><strong>Modelo</strong></td>
            <td><strong>Matricula</strong></td>
            <td><strong>Plazas</strong></td>
            <td><strong>Eliminar</strong></td>
            <td><strong>Actualizar</strong></td>
            
        <%
        for(Vehicle v: vehiculos){
        %>
        <tr>
            <td><%= v.getId()%></td>
            <td><%= v.getMarca()%></td>
            <td><%= v.getModelo()%></td>
            <td><%= v.getMatricula()%></td>
            <td><%= v.getPlazas()%></td>
            <td><% if(login != null && logIn.isIsLogged()){
                %>
                <a href=http://localhost:8080/tecnaraWebapp/vehicle/deleteVehicle?id=<%=v.getId()%>>
                <img height="60px" width="60px" src="/tecnaraWebapp/img/basura.png" alt=""/>
            </a>
                <% } %>
            <td><% if(login != null && logIn.isIsLogged()){
                %>
                <a href=http://localhost:8080/tecnaraWebapp/vehicle/updateVehicle?id=<%=v.getId()%>>
                <img height="60px" width="60px" src="/tecnaraWebapp/img/update.png" alt=""/>
            </a>
                <% } %>
        </tr>
          
          <%}
        
          %>
         
        </table>
          
        <br></br>
        
    </body>
</html>
