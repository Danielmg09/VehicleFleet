<%-- 
    Document   : logout
    Created on : 13-oct-2020, 19:54:01
    Author     : daniel
--%>

<%@page import="com.mycompany.tecnarawebapp.domain.LogIn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String logoutName = (String)request.getAttribute("logoutname");
           %>
        <% 
   %>
   Goodbye,<%=logoutName%>.
   <br>
   <a href ="/tecnaraWebapp/login">Login</a>
   <h3><a href="http://localhost:8080/tecnaraWebapp">Menu principal</a></h2>
        
    </body>
</html>
