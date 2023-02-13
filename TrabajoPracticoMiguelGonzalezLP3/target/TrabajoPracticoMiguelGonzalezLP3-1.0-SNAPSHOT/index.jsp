<%-- 
    Document   : index
    Created on : 16/11/2022, 10:47:15 AM
    Author     : Miguel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
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
        <!--<h1><a href="articuloDTO?accion=listar">Listar Articulos</a></h1>-->
        
        <h1><a href="articuloDTO?accion=combo">Listar Articulos</a></h1>
            <%
                ResultSet rs = null;
                if (request.getAttribute("combo") != null){
                    rs = (ResultSet)request.getAttribute("combo");
                }
            %>
            <div class="container">
                <form action="articuloDTO?accion=guardar" method="post" id="frm" name="frm">
                    <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del articulo</label>
                    <input type="text" class="form-control" id="txtnombre" name="txtnombre" required="true">
                </div>
                <div class="mb-3">
                    <label for="marca" class="form-label">Marca</label>
                    <input type="text" class="form-control" id="txtmarca" name="txtmarca" required="true">
                </div>
                    <div class="mb-3">
                    <label for="depositos" class="form-label">Deposito</label>
                    <select name="cbodeposito" required="true">
                        <%
                            if (request.getAttribute("combo") != null) {
                                    
                                
                            while(rs.next()){
                        %>
                        <option value="<%= rs.getInt("id_deposito") %>"><%= rs.getString("descripcion") %></option>
                        <%  }
                            }%>
                    </select>
                </div>
                    <input type="submit" class="btt btn-success" onclick="return confirmacion()" value="Agregar" id="btnenviar" name="enviar">
                    <!--<a href="articuloDTO?accion=guardar">Agregar</a>-->
                </form>
                    
                    <br>
                    
                    <%
                      ResultSet rs2 = null;
                      if (request.getAttribute("listar") != null) {
                              rs2 = (ResultSet)request.getAttribute("listar");
                          }
                    %>
                    
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
            <tbody>
                <%
                    if (request.getAttribute("listar") != null) {
                            
                    while (rs2.next()) {                            
                            
                %>
                <tr class="bg-transparent">
                    <td class="text-center"><%= rs2.getInt("id_articulo") %></td>
                    <td class="text-center"><%= rs2.getString("nombre") %></td>
                    <td class="text-center"><%= rs2.getString("marca") %></td>
                    <td class="text-center"><%= rs2.getString("descripcion") %></td>
                    <td class="text-center">
                        <a href="articuloDTO?id=<%= rs2.getString("id_articulo") %>&accion=eliminar" onclick="return confirmacion()" class="btn btn-danger"><img src="img/icono-basurero.png" alt="" width="20" height="22"/></a>
                    </td>
                </tr>
                <%
                    }
                    }
                %>
            </tbody>
        </table>
                    
            </div>
    </body>
</html>
