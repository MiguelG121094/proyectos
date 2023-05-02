<%-- 
    Document   : RegistrarVenta
    Created on : 3/03/2023, 03:15:13 PM
    Author     : Miguel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <!-- Button trigger modal -->
        <!--                <div class="container">
                            <a href="ventaDTO?accion=listarCliente" data-bs-toggle="modal" data-bs-target="#modalCliente" class="btn btn-outline-primary">Clientes</a>
                            <a href="ventaDTO?accion=listarProducto" data-bs-toggle="modal" data-bs-target="#modalProducto" class="btn btn-outline-primary">Productos</a>
                        </div>-->

        <div style="text-align: center">
            <button style="height: 100%; width: 100%"><h1 style="text-align: center"><strong>REGISTRAR NUEVA VENTA</strong></h1></button>
        </div>
        <hr>

        <!-- Modal Cliente -->
        <div class="modal fade" id="modalCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Clientes</h1>
                        <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="fa-solid fa-xmark"></i></button>
                    </div>
                    <div class="modal-body">

                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr class="bg-dark">
                                    <th class="text-center text-light">Id</th>
                                    <th class="text-center text-light">Nombre</th>
                                    <th class="text-center text-light">Apellido</th>
                                    <th class="text-center text-light">Cedula</th>
                                    <th class="text-center text-light">Direccion</th>
                                    <th class="text-center text-light">Telefono</th>
                                    <th class="text-center text-light">Ruc</th>
                                    <th class="text-center text-light">Acciones</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="c" items="${cliente}">
                                    <tr>
                                        <td class="text-center">${c.getId()}</td>
                                        <td class="text-center">${c.getNombre()}</td>
                                        <td class="text-center">${c.getApellido()}</td>
                                        <td class="text-center">${c.getCi()}</td>
                                        <td class="text-center">${c.getDireccion()}</td>
                                        <td class="text-center">${c.getTelefono()}</td>
                                        <td class="text-center">${c.getRuc()}</td>
                                        <td class="text-center">
                                            <a href="Controlador?menu=RegistrarVenta&accion=BuscarCliente&idCliente=${c.getId()}" class="btn btn-primary">Seleccionar</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <a href="Controlador?menu=Cliente&accion=Listar" target="miContenedor" class="btn btn-success">Agregar Cliente</a>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
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

                            <tbody>
                                <c:forEach var="produc" items="${producto}">
                                    <tr>
                                        <td class="text-center">${produc.getId()}</td>
                                        <td class="text-center">${produc.getDescripcion()}</td>
                                        <td class="text-center">${produc.getPrecio_compra()}</td>
                                        <td class="text-center">${produc.getPrecio_venta()}</td>
                                        <td class="text-center">

                                            <a href="Controlador?menu=RegistrarVenta&accion=BuscarProducto&idProducto=${produc.getId()}" class="btn btn-primary">Seleccionar</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <a href="Controlador?menu=Producto&accion=Listar" target="miContenedor" class="btn btn-success">Agregar Producto</a>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <a href="" data-bs-toggle="modal" data-bs-target="#modalCliente" class="btn btn-outline-primary">Buscar Cliente</a>
                                    <input type="number" name="txtidCliente" id="txtidCliente" value="${cli.getId()}" class="form-control" readonly="true" placeholder="Id del Cliente" required="true">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtnombreCliente" class="form-control" value="${cli.getNombre()}" readonly="true" placeholder="Nombre del Cliente" required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <a href="" data-bs-toggle="modal" data-bs-target="#modalProducto" class="btn btn-outline-primary">Buscar Producto</a>
                                    <input type="number" value="${product.getId()}" name="txtidProducto" class="form-control" readonly="true" placeholder="Id del Producto">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" value="${product.getDescripcion()}" name="txtnombreProducto" class="form-control" readonly="true" placeholder="Descripcion">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="form-group d-flex">
                                    <div class="col-sm-7 d-flex">
                                        <input type="number" value="${product.getPrecio_venta()}" name="txtprecioVenta" class="form-control" readonly="true" placeholder="Precio">
                                    </div>
                                    <div class="col-sm-6">   
                                        <input type="number" name="txtcantidad" class="form-control" placeholder="Cantidad" required="true" min="1" pattern="^[0-9]+">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-success"
                                <c:if test="${product.getPrecio_venta() == null}"><c:out value="disabled='disabled'"/></c:if>">Agregar Producto</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label style="margin-right: 10px">Id.Venta:</label>
                            <input type="text" readonly="true" name="id_venta" value="${id_venta}" class="form-control">
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
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td class="text-center">${list.getItem()}</td>
                                        <td class="text-center">${list.getId_producto()}</td>
                                        <td class="text-center">${list.getDescripcion()}</td>
                                        <td class="text-center">${list.getPrecio()}</td>
                                        <td class="text-center">${list.getCantidad()}</td>
                                        <td class="text-center">${list.getSubTotal()}</td>
                                        <td class="text-center">
                                            <!--<a href="" class="btn btn-warning">Editar</a>-->
                                            <a href="Controlador?menu=RegistrarVenta&accion=Eliminar" class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                        <form action="Controlador?menu=RegistrarVenta" method="POST">
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <button id="btnGenrerarVenta" class="btn btn-success" type="submit" name="accion" value="GenerarVenta" class=""
                            <c:if test="${totalpagar == 0 || lista == null}"><c:out value="disabled='disabled'"/></c:if>">Generar Venta</button>
                            
                            <a href="Controlador?menu=RegistrarVenta&accion=ListarModal&nuevaV=1" class="btn btn-danger">Cancelar</a>
                        </div>                            
                        <div class="d-flex col-sm-3 ml-auto">
                            <label>Total a pagar: </label><input type="text" style="font-weight: bold" readonly="true" name="txttotal" value="Gs. ${totalpagar}" class="form-control" placeholder="Total a pagar">
                        </div>
                    </div>
                        </form>
                </div>
                        <c:if test="${mensaje == 0}">
                            <div id="mensaje" class="alert alert-success" style="text-align: center" role="alert">
                        Venta generada
                        <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-success btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                    </div>
                    </c:if>
                        <script>
                            setTimeout("document.getElementById('mensaje').style.visibility='hidden'",3000);
                        </script>
                        <div id="mensaje" style="display: none; text-align: center" class="alert alert-success" role="alert">
                            Venta generada
                            <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-success btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                        </div>
            </div>
                        
        </div>




        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
