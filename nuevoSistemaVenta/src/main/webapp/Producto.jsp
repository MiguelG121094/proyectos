<%-- 
    Document   : Producto
    Created on : 3/03/2023, 03:12:02 PM
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
        <link href="bootstrap-4.0.0/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/17ce7f89d9.js" crossorigin="anonymous"></script>
        <link href="DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
        <script src="DataTables/datatables.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <div style="text-align: center">
            <button style="height: 100%; width: 100%"><h1 style="text-align: center"><strong>FORMULARIO PRODUCTOS</strong></h1></button>
        </div>
        <hr>

        <div class="d-flex">
            <!-- Formulario -->
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="mb-3">
                            <label for="txtdescripcion" class="form-label">Descripcion</label>
                            <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" value="${product.getDescripcion()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtprecio_compra" class="form-label">Precio de compra</label>
                            <input type="number" class="form-control" id="txtprecio_compra" name="txtprecio_compra" value="${product.getPrecio_compra()}" required="true" min="1" pattern="^[0-9]+">
                        </div>
                        <div class="mb-3">
                            <label for="txtprecio_venta" class="form-label">Precio de venta</label>
                            <input type="number" class="form-control" id="txtprecio_venta" name="txtprecio_venta" value="${product.getPrecio_venta()}" required="true" min="1" pattern="^[0-9]+">
                        </div>
                        <div class="mb-3">
                            <label for="txtcant_minima" class="form-label">Cantidad mínima</label>
                            <input type="number" class="form-control" id="txtcant_minima" name="txtcant_minima" value="${product.getCant_minima()}" required="true" min="1" pattern="^[0-9]+">
                        </div>

                        <button type="submit" name="accion" value="Insertar" class="btn btn-success"
                                <c:if test="${product.getDescripcion() != null}"><c:out value="disabled='disabled'"/></c:if>">Agregar</button>

                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary" 
                                <c:if test="${product.getDescripcion() == null}"><c:out value="disabled='disabled'"/></c:if>">Actualizar</button>

                        <a href="Controlador?menu=Producto&accion=Cancelar" class="btn btn-danger">Cancelar</a>
                        </form>
                    </div>
                </div>

                <!-- Tabla -->
                <div class="col-sm-8">
                    <table id="tablaProductos" class="table table-hover table-bordered table-striped">
                        <thead>
                            <tr class="bg-dark">
                                <th class="text-center text-light">Id</th>
                                <th class="text-center text-light">Descripcion</th>
                                <th class="text-center text-light">Precio de Compra</th>
                                <th class="text-center text-light">Precio de Venta</th>
                                <th class="text-center text-light">Canti. mínima</th>
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
                                <td class="text-center">${produc.getCant_minima()}</td>
                                <td class="text-center">
                                    <a href="Controlador?menu=Producto&accion=Editar&id=${produc.getId()}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Producto&accion=Eliminar&id=${produc.getId()}" class="btn btn-danger" >Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
                                <c:if test="${mensaje == 0}">
                                <div id="mensaje" class="alert alert-success" style="position:absolute; top: 12px; right: 10px;"" role="alert">
                                    Procesado correctamente
                                    <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-success btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                                </div>
                            </c:if>
                            <script>
                                setTimeout("document.getElementById('mensaje').style.visibility='hidden'",3000);
                            </script>
                            <c:if test="${mensaje == 1}">
                                <div id="mensaje" class="alert alert-danger" style="position:absolute; top: 12px; right: 10px;"" role="alert">
                                    Eliminado correctamente
                                    <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-danger btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                                </div>
                            </c:if>
        
        
        <script>

              $(document).ready(function(){
              $('#tablaProductos').DataTable();
              })
  
              var table = new DataTable('#tablaProductos', {
                language: {
                    url: "DataTables/es-ES.json",
                },
                });
        </script>
        
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
