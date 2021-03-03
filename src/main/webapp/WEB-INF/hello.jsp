<%-- 
    Document   : hello
    Created on : 06-oct-2020, 19:24:26
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!2</h1>
        <% HttpSession mySession = request.getSession(false);
        int resultado = (int) mySession.getAttribute("resultado");
        %>
        <%= resultado %>
    </body>
</html>
