<%-- 
    Document   : updateVehicle
    Created on : 09-oct-2020, 11:22:51
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
        <h1>Actualizar vehiculo:</h1>
        <% HttpSession mySession = request.getSession(false);
        String marca = (String)mySession.getAttribute("marca");
        String modelo = (String)mySession.getAttribute("modelo");
        String matricula = (String)mySession.getAttribute("matricula");
        int plazas = (int)mySession.getAttribute("plazas");
        int id = (int)mySession.getAttribute("id");
        %>
        <form action ="/tecnaraWebapp/vehicle/updateVehicle" method="post">
            <label for="id">id a modificar:</label>
            <input type="hidden" name="id" value = "<%=id%>">
            <br></br>
            <label for="marca">Marca:</label>
            <input type="text" name="marca" value = "<%=marca%>">
            <label for="modelo">Modelo:</label>
            <input type="text" name="modelo" value = "<%=modelo%>">
            <label for="matricula">Matricula:</label>
            <input type="text" name="matricula" value = "<%=matricula%>">
            <label for="plazas">Plazas:</label>
            <input type="text" name="plazas" value = "<%=plazas%>">
            <input type="submit" value="actualizar">  
            
        </form>
        <br></br>
        <h3><a href="http://localhost:8080/tecnaraWebapp/vehicle/listAll">Volver a la lista</a></h3>
    </body>
</html>
