<%-- 
    Document   : listar
    Created on : 16/11/2022, 10:58:39 AM
    Author     : Miguel
--%>

<%@page import="Modelo.articuloDAO"%>
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
        <h1>Articulos</h1>
        <hr>
        
        <div class="container">
            <form name="formArticulos" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del articulo</label>
                    <input type="text" class="form-control" id="txtnombre" name="txtnombre" required="true">
                </div>
                <div class="mb-3">
                    <label for="marca" class="form-label">Marca</label>
                    <input type="text" class="form-control" id="txtmarca" name="txtmarca" required="true">
                </div>
                <div class="mb-3">
                    <label for="ciudades" class="form-label">Deposito</label>
                    <select name="cbociudad">
                        <%
                            ResultSet rs2 = (ResultSet)request.getAttribute("combo");
                            while(rs2.next()){
                        %>
                        <option value="<%= rs2.getInt("id_deposito") %>"><%= rs2.getString("descripcion") %></option>
                        <% } %>
                    </select>
                </div>
                <a href="articuloDTO?accion=agregar" type="submit" class="btn btn-success" onclick="return confirmacion()">Agregar</a>
            </form>
        </div>
        
        <hr>
        <table class="table table-bordered table-striped">
            <thead>
                <tr class="bg-dark">
                    <th class="text-center text-light">Id Articulo</th>
                    <th class="text-center text-light">Nombre</th>
                    <th class="text-center text-light">Marca</th>
                    <th class="text-center text-light">Deposito</th>
                    <th class="text-center text-light">Acciones</th>
                </tr>
            </thead>
            <%
                ResultSet rs = (ResultSet)request.getAttribute("datos");
            %>
            <tbody>
                <%
                    while (rs.next()) {                            
                            
                %>
                <tr class="bg-transparent">
                    <td class="text-center"><%= rs.getInt("id_articulo") %></td>
                    <td class="text-center"><%= rs.getString("nombre") %></td>
                    <td class="text-center"><%= rs.getString("marca") %></td>
                    <td class="text-center"><%= rs.getString("descripcion") %></td>
                    <td class="text-center">
                        <a href="articuloDTO?id=<%= rs.getString("id_articulo") %>&accion=eliminar" onclick="return confirmacion()" class="btn btn-danger"><img src="img/icono-basurero.png" alt="" width="20" height="22"/></a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        
            </form>
        </div>
    </body>
</html>
