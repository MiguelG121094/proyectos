<%-- 
    Document   : menuPrincipal
    Created on : 8/12/2022, 01:42:58 PM
    Author     : Miguel
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
                            <a class="nav-link active" aria-current="page" href="productoDTO?accion=listar">Productos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Nueva
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ventasDTO?accion=listarCliente">Venta</a></li>
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
                                <li><a class="dropdown-item" href="productoDTO?accion=listar">Producto</a></li>
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

        <!-- contenido del menu-->
        <div>
            <main>
                <div class="container-fluid px-4 text-center">
                    <h1 class="mt-4">SISTEMA COMPRA / VENTA</h1>
                    
                    <div class="breadcrumb mb-4 card-footer d-flex">
                                <div class="col-sm-6">
                                    <div class="breadcrumb-item active"><strong>Usuario activo:</strong> <%= elUsuario%></div>
                                </div>
                                <div class="col-sm-6">
                                    <% 
                                Date fecha = new Date();
                                DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy");
                            %>
                            <div class="breadcrumb-item active"><strong>Fecha:</strong> <%=dateFormat.format(fecha)%></div>
                                </div>
                            </div>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-success text-white mb-4 text-center">
                                <div class="container"><h1 style="margin-left: 40px;margin-top: 5px">
                                        <strong>Venta <span style="float: right;font-size: 64px;opacity: 0.8" >
                                                <ion-icon name="cash-outline"></ion-icon></span></strong></h1>
                                </div>
                                <div class="card-footer">
                                    <a class="text-white" href="ventaDTO?accion=listar">Realizar una venta <i class="fa-solid fa-circle-arrow-right"></i></a>
                                    <!--<a class="text-white" href="ventasDTO?accion=listar">Realizar una venta <i class="fa-solid fa-circle-arrow-right"></i></a>-->
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-primary text-white mb-4 text-center">
                                <div class="container"><h1 style="margin-left: 40px;margin-top: 5px">
                                        <strong>Compra <span style="float: right;font-size: 64px;opacity: 0.8" >
                                                <ion-icon name="archive-outline"></ion-icon></span></strong></h1>
                                </div>
                                <div class="card-footer">
                                    <a class="text-white" href="#">Realizar una compra <i class="fa-solid fa-circle-arrow-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-warning text-white mb-4 text-center">
                                <div class="container"><h1 style="margin-left: 40px;margin-top: 5px">
                                        <strong>Inventario <span style="float: right;font-size: 64px;opacity: 0.8" >
                                                <ion-icon name="cube-outline"></ion-icon></ion-icon></span></strong></h1>
                                </div>
                                <div class="card-footer">
                                    <a class="text-white" href="#">Inventario de productos <i class="fa-solid fa-circle-arrow-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-danger text-white mb-4 text-center">
                                <div class="container"><h1 style="margin-left: 40px;margin-top: 5px">
                                        <strong>Reportes <span style="float: right;font-size: 64px;opacity: 0.8" >
                                                <ion-icon name="reader-outline"></ion-icon></span></strong></h1>
                                </div>
                                <div class="card-footer">
                                    <a class="text-white" href="#">Reportes realizados <i class="fa-solid fa-circle-arrow-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fa-solid fa-cash-register"></i>
                                    Ultimas Ventas realizadas
                                </div>
                                <div class="card-body"><canvas width="100%" height="40"></canvas></div>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fa-solid fa-box-open"></i>
                                    Ultimas Compras realizadas
                                </div>
                                <div class="card-body"><canvas width="100%" height="40"></canvas></div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

            <div>
                <div class="container-fluid px-4 text-center">
                    <a href="agregarPersona.jsp"><img src="img/addNew.jpg" alt=""/></a>
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
