<%-- 
    Document   : generarVenta
    Created on : 20/01/2023, 02:31:40 AM
    Author     : Miguel
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/17ce7f89d9.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <%
            ResultSet rs;
            ResultSet rs2;
            rs = (ResultSet) request.getAttribute("datosCliente");
            rs2 = (ResultSet) request.getAttribute("datosProducto");

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
                            <a class="nav-link active" aria-current="page" href="productoDTO?accion=listar">Productos</a>
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
                <h1>Nueva Venta</h1>
            </div>
            <hr>
            <div style="min-height: 62vh">


                <!-- Button trigger modal -->
                <div class="container">
                    <a href="ventaDTO?accion=listarCliente" data-bs-toggle="modal" data-bs-target="#modalCliente" class="btn btn-outline-primary">Clientes</a>
                    <a href="ventaDTO?accion=listarProducto" data-bs-toggle="modal" data-bs-target="#modalProducto" class="btn btn-outline-primary">Productos</a>
                </div>



                <!-- Modal Producto-->
                <div class="modal fade" id="modalProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Productos</h1>
                                <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="fa-solid fa-xmark"></i></button>
                            </div>
                            <div class="modal-body">

                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr class="bg-dark">
                                            <th class="text-center text-light">Id</th>
                                            <th class="text-center text-light">Descripcion</th>
                                            <th class="text-center text-light">Precio de compra</th>
                                            <th class="text-center text-light">Precio de venta</th>
                                            <th class="text-center text-light">Acciones</th>
                                        </tr>
                                    </thead>
                                    <%
                                        rs2 = (ResultSet) request.getAttribute("datosProducto");
                                    %>
                                    <tbody>
                                        <%
                                            while (rs2.next()) {
                                        %>
                                        <tr>
                                            <td class="text-center"><%= rs2.getInt("id_producto")%></td>
                                            <td class="text-center"><%= rs2.getString("descripcion")%></td>
                                            <td class="text-center"><%= rs2.getInt("pro_precio_compra")%></td>
                                            <td class="text-center"><%= rs2.getInt("pro_precio_venta")%></td>
                                            <td class="text-center">

                                                <a href="ventaDTO?id_producto=<%= rs2.getInt("id_producto")%>&accion=cargar_producto" class="btn btn-primary">Seleccionar</a>

                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <%
                    ResultSet rs4 = null;
                    if (request.getAttribute("datosProducto_id") != null) {
                        rs4 = (ResultSet) request.getAttribute("datosProducto_id");
                    }
                %>

                <div class="d-flex">
                    <div class="col-sm-5">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del Producto</label>
                                </div>
                                <form name="formDatosProducto" action="ventaDTO?accion=agregarDatos_DetVenta" method="POST">
                                    <div class="form-group d-flex">
                                        <div class="col-sm-6 d-flex">
                                            <a href="productoDTO?accion=listar" data-bs-toggle="modal" data-bs-target="#modalProducto" class="btn btn-outline-primary">Buscar Producto</a>
                                            <%
                                                if (request.getAttribute("datosProducto_id") != null) {
                                                    rs4 = (ResultSet) request.getAttribute("datosProducto_id");
                                                    while (rs4.next()) {
                                                    
                                            %>
                                            <input type="text" name="txtidProducto" value="<%= rs4.getInt("id_producto")%>" class="form-control" readonly="true" placeholder="Id del Producto">

                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="txtdescripcion" value="<%= rs4.getString("descripcion")%>" class="form-control" readonly="true" placeholder="Descripcion">
                                            
                                        </div>
                                    </div>
                                    <div class="form-group d-flex">
                                        <div class="form-group d-flex">
                                            <div class="col-sm-7 d-flex">
                                                <input type="text" name="txtprecio_venta" value="<%= rs4.getInt("pro_precio_venta")%>" class="form-control" readonly="true" placeholder="Precio">
                                            </div>
                                            <div class="col-sm-6">   
                                                <input type="number" name="txtcantidad" class="form-control" placeholder="Cantidad" required="true" min="1" pattern="^[0-9]+">
                                            </div>
                                            <%  }
                                                }%>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-outline-success">Agregar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>




                    <div class="col-sm-7">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex col-sm-5 ml-auto">
                                    <label>Id.Venta:</label>
                                    <input type="text" name="id_venta" class="form-control">
                                </div>
                                <br>
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr class="bg-dark">
                                            <th class="text-center text-light">Nro</th>
                                            <th class="text-center text-light">Codigo</th>
                                            <th class="text-center text-light">Descripcion</th>
                                            <th class="text-center text-light">Precio</th>
                                            <th class="text-center text-light">Cantidad</th>
                                            <th class="text-center text-light">SubTotal</th>
                                            <th class="text-center text-light">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-center"></td>
                                            <td class="text-center"></td>
                                            <td class="text-center"></td>
                                            <td class="text-center"></td>
                                            <td class="text-center"></td>
                                            <td class="text-center"></td>
                                            <td class="text-center">
                                                <a href="" class="btn btn-warning">Editar</a>
                                                <a href="" class="btn btn-danger" >Eliminar</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="card-footer d-flex">
                                <div class="col-sm-6">
                                    <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                                    <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                                </div>
                                <div class="col-sm-3 ml-auto">
                                    <input type="text" name="txttotalApagar" value="" class="form-control" placeholder="Total a pagar">
                                </div>
                            </div>
                        </div>
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
