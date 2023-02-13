<%-- 
    Document   : agregar
    Created on : 1/10/2022, 09:31:50 AM
    Author     : Miguel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- Javascript para que haga un mensaje de confirmacion al agregar -->
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
        <h1>Agregar Persona</h1>
        </div>
        <hr>
        <div class="container">
            <form name="formPersonas" action="ciudad1DTO?accion=agregar" method="POST">
                <div class="mb-3">
                    <label for="descripcion" class="form-label">Ciudad</label>
                    <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" required="true">
                </div>
                <button type="submit" class="btn btn-primary" onclick="return confirmacion()">Guardar</button>
            </form>
        </div>
    </body>
</html>
