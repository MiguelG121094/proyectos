<%-- 
    Document   : Principal
    Created on : 23/02/2023, 08:10:14 PM
    Author     : Miguel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap -->
        <link href="bootstrap-4.0.0/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/17ce7f89d9.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <!-- navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="Controlador?menu=MenuPrincipal&accion=ListarVentas" target="miContenedor">Menu</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Controlador?menu=Producto&accion=Listar" target="miContenedor">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="miContenedor">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Controlador?menu=Cliente&accion=Listar" target="miContenedor">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Controlador?menu=Proveedor&accion=Listar" target="miContenedor">Proveedor</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Nueva
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="Controlador?menu=RegistrarVenta&accion=ListarModal&nuevaV=1" target="miContenedor">Venta</a></li>
                                <li><a class="dropdown-item" href="#" target="miContenedor">Compra</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">

                            Bienvenido: ${empleado.getNombre()}

                        </a>
                        <ul class="dropdown-menu">
                            <li><center><img style="border-radius: 50% " src="img/usuario.jpg" alt="" width="80"/></center></li>
                    <li><center><a class="dropdown-item" href="#">Usuario Activo
                            <br>
                            ${empleado.getUsuario()}
                        </a></center></li>
                    <li><hr class="dropdown-divider"></li>
                    <form method="POST" class="dropdown-item" action="validar">
                        <li><center><button class="btn btn-danger center-block" type="submit" name="accion" value="Salir">Cerrar Sesion</button></center></li>
                    </form>
                    <%
                      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                      if(session.getAttribute("empleado") == null){
                      response.sendRedirect("index.jsp");
                        }  
                    %>
                    </ul>
                    </li>
                </div>
            </div>
        </nav>

        <!-- contenido del menu-->
        <div class="m-3" style="height: 680px">
            <iframe name="miContenedor" src="MenuPrincipal.jsp" style="height: 100%; width: 100%; border: none" frameBorder="1"></iframe>
        </div>

        
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Sistema Compra / Venta</div>
                    <div>
                        <a href="manualUsuario/manual_de_usuario.pdf" target="_blank">Manual de usuario</a>
                    </div>
                </div>
            </div>
        </footer>



        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
