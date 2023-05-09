<%-- 
    Document   : Proveedor
    Created on : 4/03/2023, 06:42:13 PM
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
        
        <div style="text-align: center">
            <button style="height: 100%; width: 100%"><h1 style="text-align: center"><strong>FORMULARIO PROVEEDORES</strong></h1></button>
        </div>
        <hr>

        <div class="d-flex">
            <!-- Formulario -->
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Proveedor" method="POST">
                        <div class="mb-3">
                            <label for="txtnombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="txtnombre" name="txtnombre" value="${pro.getNombre()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtapellido" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="txtapellido" name="txtapellido" value="${pro.getApellido()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtcedula" class="form-label">Cedula</label>
                            <input type="text" class="form-control" id="txtcedula" name="txtcedula" value="${pro.getCi()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtdireccion" class="form-label">Direccion</label>
                            <input type="text" class="form-control" id="txtdireccion" name="txtdireccion" value="${pro.getDireccion()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txttelefono" class="form-label">Telefono</label>
                            <input type="text" class="form-control" id="txttelefono" name="txttelefono" value="${pro.getTelefono()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtruc" class="form-label">Ruc</label>
                            <input type="text" class="form-control" id="txtruc" name="txtruc" value="${pro.getRuc()}" required="true">
                        </div>

                        <button type="submit" name="accion" value="Insertar" class="btn btn-success"
                                <c:if test="${pro.getNombre() != null}"><c:out value="disabled='disabled'"/></c:if>">Agregar</button>

                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary" 
                                <c:if test="${pro.getNombre() == null}"><c:out value="disabled='disabled'"/></c:if>">Actualizar</button>
                                
                        <a href="Controlador?menu=Proveedor&accion=Cancelar" class="btn btn-danger">Cancelar</a>

                        </form>
                    </div>
                </div>

                <!-- Tabla -->
                <div class="col-sm-8">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                            <tr class="bg-dark">
                                <th class="text-center text-light">Id</th>
                                <th class="text-center text-light">Nombre</th>
                                <th class="text-center text-light">Apellido</th>
                                <th class="text-center text-light">Cédula</th>
                                <th class="text-center text-light">Dirección</th>
                                <th class="text-center text-light">Teléfono</th>
                                <th class="text-center text-light">Ruc</th>
                                <th class="text-center text-light">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="p" items="${proveedor}">
                            <tr>
                                <td class="text-center">${p.getId()}</td>
                                <td class="text-center">${p.getNombre()}</td>
                                <td class="text-center">${p.getApellido()}</td>
                                <td class="text-center">${p.getCi()}</td>
                                <td class="text-center">${p.getDireccion()}</td>
                                <td class="text-center">${p.getTelefono()}</td>
                                <td class="text-center">${p.getRuc()}</td>
                                <td class="text-center">
                                    <a href="Controlador?menu=Proveedor&accion=Editar&id=${p.getId()}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Proveedor&accion=Eliminar&id=${p.getId()}" class="btn btn-danger" >Eliminar</a>
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
        
        
        
        
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
