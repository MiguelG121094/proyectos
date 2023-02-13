<%-- 
    Document   : listarProveedor
    Created on : 18/01/2023, 03:01:24 PM
    Author     : Miguel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/17ce7f89d9.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            String elUsuario = (String) session.getAttribute("usuario");

            response.setHeader("Pragna", "no-cache");
            response.setHeader("Cache-control", "must-revalidate");
            response.setHeader("Cache-control", "no-cache");
            response.setHeader("Cache-control", "no-store");
            response.setDateHeader("Expires", 0);

            try {
                if (session.getAttribute("usuario") == null) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        %>
        <!-- navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="menuPrincipal.jsp">Menu</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Productos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Nueva
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Venta</a></li>
                                <li><a class="dropdown-item" href="#">Compra</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Lista de...
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="clienteDTO?accion=listar">Cliente</a></li>
                                <li><a class="dropdown-item" href="empleadoDTO?accion=listar">Empleado</a></li>
                                <li><a class="dropdown-item" href="proveedorDTO?accion=listar">Proveedor</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Producto</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Reportes</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <div class="navbar-nav me-2">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">

                            Bienvenido: <%= elUsuario%>



                        </a>
                        <ul class="dropdown-menu">
                            <li><center><img style="border-radius: 50% " src="img/usuario.jpg" alt="" width="80"/></center></li>
                    <li><center><a class="dropdown-item" href="#">Usuario Activo
                            <br>
                            <%= elUsuario%>
                        </a></center></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><center><a class="dropdown-item" href="cerrar.jsp">Cerrar Sesion</a></center></li>
                    </ul>
                    </li>
                </div>
            </div>
        </nav>

        <div>
            <div class="container">
                <h1>Lista de Proveedores</h1>
            </div>
            <hr>
            <div class="container" style="min-height: 62vh">
                <div class="navbar">
                    <a href="agregarProveedor.jsp" class="btn btn-outline-success">Agregar</a>
                    <a href="reportes/reporte_per1.jsp" target="_blank" class="btn btn-outline-info">Generar Reporte <i class="fa-solid fa-print"></i></a>
                    <form class="form-inline" name="txtbuscar" action="">
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
                                    <th class="text-center text-light">Nombre</th>
                                    <th class="text-center text-light">Apellido</th>
                                    <th class="text-center text-light">Cedula</th>
                                    <th class="text-center text-light">Direccion</th>
                                    <th class="text-center text-light">Telefono</th>
                                    <th class="text-center text-light">ruc</th>
                                    <th class="text-center text-light">Acciones</th>
                                </tr>
                            </thead>
                            <%
                                ResultSet rs = (ResultSet) request.getAttribute("datos");
                            %>
                            <tbody>
                                <%
                                    while (rs.next()) {
                                %>
                                <tr>
                                    <td class="text-center"><%= rs.getInt("id_proveedor")%></td>
                                    <td class="text-center"><%= rs.getString("nombre")%></td>
                                    <td class="text-center"><%= rs.getString("apellido")%></td>
                                    <td class="text-center"><%= rs.getInt("ci")%></td>
                                    <td class="text-center"><%= rs.getString("direccion")%></td>
                                    <td class="text-center"><%= rs.getString("telefono")%></td>
                                    <td class="text-center"><%= rs.getString("ruc")%></td>
                                    <td class="text-center">
                                        <a href="proveedorDTO?id=<%= rs.getString("id_proveedor") %>&accion=editar_listar" class="btn btn-warning">Editar</a>
                                        <a href="proveedorDTO?id=<%= rs.getString("id_proveedor") %>&accion=eliminar" class="btn btn-danger" >Eliminar</a>
                                        <a href="" target="_blank" class="btn btn-info" ><i class="fa-solid fa-print"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>




        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
