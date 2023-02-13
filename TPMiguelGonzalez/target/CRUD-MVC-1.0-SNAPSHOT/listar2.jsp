<%-- 
    Document   : listar
    Created on : 1/10/2022, 09:31:35 AM
    Author     : Miguel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function confirmacion(){
                var respuesta = confirm("Estás seguro?");
                if (respuesta === true){
                    return true;
                }else{
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include> <!-- incluimos la codificacion que se encuentra en navbar.jsp -->
        <div class="container">
        <h1>Listar Persona</h1>
        </div>
        <hr>
        <div class="container">
        <div class="navbar">
            <a href="personaDTO?accion=combo" class="btn btn-outline-success">Agregar</a>
            <form class="form-inline" name="txtbuscar" action="personaDTO?accion=">
                <input class="form-control" placeholder="Buscar" type="search" name="">
                <input class="btn btn-outline-primary" type="submit" value="Buscar">
            </form>
        </div>
        <div class="container text-capitalize">
            
            <div class="row">
            <table class="table table-bordered table-striped">
            <thead>
                <tr class="bg-info">
                    <th class="text-center">Id</th>
                    <th class="text-center">Cedula</th>
                    <th class="text-center">Nomnbre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>
            <%
                ResultSet rs = (ResultSet)request.getAttribute("datos"); //Cast
                %>
            <tbody>
                <%
                    while(rs.next()){
                    %>
                <tr>
                    <td class="text-center"><%= rs.getInt("id_persona") %></td>
                    <td class="text-center"><%= rs.getString("cedula") %></td>
                    <td class="text-center"><%= rs.getString("nombre") %></td>
                    <td class="text-center"><%= rs.getString("apellido") %></td>
                    <td class="text-center">
                        <a href="personaDTO?id=<%= rs.getString("id_persona") %>&accion=editar_listar" class="btn btn-warning">Editar</a>
                        <a href="personaDTO?id=<%= rs.getString("id_persona") %>&accion=eliminar" onclick="return confirmacion()" class="btn btn-danger" >Eliminar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
            </table>
            </div>
        </div>
    </body>
</html>
