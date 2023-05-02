<%-- 
    Document   : MenuPrincipal
    Created on : 20/03/2023, 04:38:39 PM
    Author     : Miguel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div>
            <div class="container-fluid px-4 text-center">
                <div style="text-align: center">
                    <button style="height: 100%; width: 100%"><h1 style="text-align: center"><strong>SISTEMA VENTAS</strong></h1></button>
                </div>
                <hr>

                <div class="breadcrumb mb-4 card-footer d-flex">
                    <div class="col-sm-6">
                        <div class="breadcrumb-item active"><strong>Usuario activo:</strong> ${empleado.getUsuario()}</div>
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
                                <a class="text-white" href="Controlador?menu=RegistrarVenta&accion=ListarModal&nuevaV=1" target="miContenedor">Realizar Venta <i class="fa-solid fa-circle-arrow-right"></i></a>
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
                                <h5><i class="fa-solid fa-cash-register"></i>
                                Últimas Ventas realizadas</h5>
                            </div>
                            <div class=""><canvas width="100%" height="0"></canvas>

                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr class="bg-dark">
                                            <th class="text-center text-light">Id. Venta</th>
                                            <th class="text-center text-light">Cliente</th>
                                            <th class="text-center text-light">Producto</th>
                                            <th class="text-center text-light">SubTotal</th>
                                            <th class="text-center text-light">Fecha</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="listVenta" items="${listaVenta}">
                                            <tr>
                                                <td class="text-center">${listVenta.getId_venta()}</td>
                                                <td class="text-center">${listVenta.getNombre_cliente()}</td>
                                                <td class="text-center">${listVenta.getDescripcion()}</td>
                                                <td class="text-center">${listVenta.getMonto()}</td>
                                                <td class="text-center">${listVenta.getFecha()}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6">
                        <div class="card mb-4">
                            <div class="card-header">
                                <h5><i class="fa-solid fa-box-open"></i>
                                Últimas Compras realizadas</h5>
                            </div>
                            <div class="card-body"><canvas width="100%" height="40"></canvas></div>
                        </div>
                    </div>
                </div>
            </div>

            <div>
                
            </div>
        </div>





        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
