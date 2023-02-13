<%-- 
    Document   : index
    Created on : 1/10/2022, 09:29:39 AM
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
            <div class="container">
        <h1>Agregar articulo</h1>
        </div>
        <hr>
<!--        <div class="container">
            <form name="formPersonas" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del articulo</label>
                    <input type="text" class="form-control" id="txtnombre" name="txtnombre" required="true">
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Marca</label>
                    <input type="text" class="form-control" id="txtapellido" name="txtapellido" required="true">
                </div>
                <div class="mb-3">
                    <label for="ciudades" class="form-label">Deposito</label>
                    <select name="cbociudad">
                        <option value="">Dep 1</option>
                        <option value="">Dep 2</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success" onclick="return confirmacion()">Agregar</button>
            </form>
        </div>-->
        
        <hr> 
        
        <div class="container text-capitalize">
            
            <div class="row">
            <table class="table table-bordered table-striped">
            <thead>
                <tr class="bg-info">
                    <th class="text-center">Id</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Marca</th>
                    <th class="text-center">Deposito</th>
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>
            <%
                ResultSet rs = (ResultSet)request.getAttribute("datos");
                
            %>
            <tbody>
                <%
                    while(rs.next()){
                    
                %>
                <tr>
                    <td class="text-center"><%= rs.getInt("id_articulo") %></td>
                    <td class="text-center"><%= rs.getString("nombre") %></td>
                    <td class="text-center"><%= rs.getString("marca") %></td>
                    <td class="text-center"><%= rs.getInt("id_deposito") %></td>
                    <td class="text-center">
                        <a href="" onclick="return confirmacion()" class="btn btn-danger text-center"><img src="img/icono-basurero.png" alt="" width="30" height="32"/></a>
                        
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
            </table>
            </div>
        </div>
        
    </body>
</html>