<%-- 
    Document   : editar
    Created on : 1/10/2022, 09:32:20 AM
    Author     : Miguel
--%>

<%@page import="Modelo.personaDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- Javascript para que haga un mensaje de confirmacion al agregar-->
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
        <h1>Editar Persona</h1>
        </div>
        <hr>
        <div class="container">
        <%
            ResultSet rs;
            //personaDAO dao = new personaDAO();
            rs = (ResultSet)request.getAttribute("datos");   
            System.out.println("este");
            while(rs.next()){
        %>    
        <form name="formPersonas" action="personaDTO?accion=editar" method="POST">
                <div class="mb-3">
                    <label class="form-label">Id Persona</label>
                    <input type="text" class="form-control" id="txtid" name="txtid" value="<%= rs.getInt("id_persona") %>">
                </div>
                <div class="mb-3">
                    <label for="cedula" class="form-label">Cédula</label>
                    <input type="text" class="form-control" id="txtcedula" name="txtcedula" value="<%= rs.getString("cedula") %>">
                </div>
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombres</label>
                    <input type="text" class="form-control" id="txtnombre" name="txtnombre" value="<%= rs.getString("nombre") %>">
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="txtapellido" name="txtapellido" value="<%= rs.getString("apellido") %>">
                </div>
                <button type="submit" class="btn btn-primary" onclick="return confirmacion()">Guardar Cambios</button>
            </form>
         <% } %>
    </div>
    </body>
</html>