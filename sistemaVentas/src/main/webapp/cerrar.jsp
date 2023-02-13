<%-- 
    Document   : cerrar
    Created on : 12/01/2023, 11:28:05 PM
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
    HttpSession cerrar = request.getSession();
    cerrar.removeAttribute("login");
    session.invalidate();
    
    %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="img/fondo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Sesión cerrada...</h1> <h2><a href="index.jsp"><font color="black">Volver a iniciar sesión</font></a></h2>
    </body>
</html>
