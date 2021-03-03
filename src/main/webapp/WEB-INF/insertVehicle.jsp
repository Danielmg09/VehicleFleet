<%-- 
    Document   : addVehicle
    Created on : 09-oct-2020, 10:20:33
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
        <h1>Añadir nuevo vehiculo:</h1>
        <form action ="/tecnaraWebapp/vehicle/addVehicle" method="post">
            <label for="marca">Marca:</label>
            <input type="text" name="marca">
            <label for="modelo">Modelo:</label>
            <input type="text" name="modelo">
            <label for="matricula">Matricula:</label>
            <input type="text" name="matricula">
            <input type="submit" value="añadir">   
        </form>
        <br></br>
        <h3><a href="http://localhost:8080/tecnaraWebapp/vehicle/listAll">Volver a la lista</a></h3>
    </body>
</html>
