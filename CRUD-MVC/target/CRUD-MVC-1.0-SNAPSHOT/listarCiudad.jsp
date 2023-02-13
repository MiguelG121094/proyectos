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
        <h1>Lista de Ciudades</h1>
        </div>
        <hr>
        <div class="container">
        <div class="navbar">
            <a href="agregarCiudad.jsp" class="btn btn-outline-success">Agregar</a>
            <!--<a href="reportes/reporte_per1.jsp" target="_blank" class="btn btn-outline-info">Generar Reporte <img src="img/icono-impresora.png" alt="" width="20" height="22"/></a>-->
            <form class="form-inline" name="txtbuscar" action="ciudadDTO?accion=">
                <input class="form-control" placeholder="Buscar" type="search" name="">
                <input class="btn btn-outline-primary" type="submit" value="Buscar">
            </form>
        </div>
        <div class="container text-capitalize">
            
            <div class="row">
            <table class="table table-bordered table-striped">
            <thead>
                <tr class="bg-dark">
                    <th class="text-center text-light">Id</th>
                    <th class="text-center text-light">Ciudad</th>
                    <th class="text-center text-light">Acciones</th>
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
                    <td class="text-center"><%= rs.getInt("id_ciudad") %></td>
                    <td class="text-center"><%= rs.getString("descripcion") %></td>
                    <td class="text-center">
                        <a href="ciudad1DTO?id=<%= rs.getString("id_ciudad") %>&accion=editar_listar" class="btn btn-warning">Editar</a>
                        <a href="ciudad1DTO?id=<%= rs.getString("id_ciudad") %>&accion=eliminar" onclick="return confirmacion()" class="btn btn-danger" >Eliminar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
            </table>
            </div>
        </div>
        </div>
    </body>
</html>
