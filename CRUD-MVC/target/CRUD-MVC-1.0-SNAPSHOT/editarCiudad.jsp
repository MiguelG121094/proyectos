<%-- 
    Document   : editar
    Created on : 1/10/2022, 09:32:20 AM
    Author     : Miguel
--%>

<%@page import="Modelo.ciudadDAO"%>
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
        <h1>Editar Ciudad</h1>
        </div>
        <hr>
        <div class="container">
        <%
            ResultSet rs;
            rs = (ResultSet)request.getAttribute("datos");
            //System.out.println(rs.getInt("id_ciudad") + rs.getString("descripcion"));
            while(rs.next()){
        %>    
        <form name="formCiudad" action="ciudad1DTO?accion=editar" method="POST">
                <div class="mb-3">
                    <label class="form-label">Id Ciudad</label>
                    <input type="text" class="form-control" readonly="true" id="txtid" name="txtid" value="<%= rs.getInt("id_ciudad") %>">
                </div>
                <div class="mb-3">
                    <label for="cedula" class="form-label">Ciudad</label>
                    <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" value="<%= rs.getString("descripcion") %>">
                </div>
                <button type="submit" class="btn btn-primary" onclick="return confirmacion()">Guardar Cambios</button>
            </form>
         <% } %>
    </div>
    </body>
</html>