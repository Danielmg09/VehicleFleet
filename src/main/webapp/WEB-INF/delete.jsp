<%-- 
    Document   : delete
    Created on : 07-oct-2020, 21:23:19
    Author     : daniel
--%>

<%@page import="com.mycompany.tecnarawebapp.domain.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% HttpSession mySession = request.getSession(false);
        Vehicle resultado = (Vehicle)mySession.getAttribute("resultado");
        %>
        <h2><%= "Has borrado el vehiculo"%></h2>
        <h2><%= resultado.getMarca()%></h2>
        <h2><%= resultado.getModelo()%></h2>
        <h2><%= resultado.getMatricula()%></h2>

          
    </body>
</html>
