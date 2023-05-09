<%-- 
    Document   : Empleado
    Created on : 3/03/2023, 03:12:14 PM
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
            <button style="height: 100%; width: 100%"><h1 style="text-align: center"><strong>FORMULARIO EMPLEADOS</strong></h1></button>
        </div>
        <hr>
        
        <div class="d-flex">
            <!-- Formulario -->
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="mb-3">
                            <label for="txtnombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="txtnombre" name="txtnombre" value="${emp.getNombre()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtapellido" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="txtapellido" name="txtapellido" value="${emp.getApellido()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtcedula" class="form-label">Cedula</label>
                            <input type="text" class="form-control" id="txtcedula" name="txtcedula" value="${emp.getCi()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtdireccion" class="form-label">Direccion</label>
                            <input type="text" class="form-control" id="txtdireccion" name="txtdireccion" value="${emp.getDireccion()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txttelefono" class="form-label">Telefono</label>
                            <input type="text" class="form-control" id="txttelefono" name="txttelefono" value="${emp.getTelefono()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtusuario" class="form-label">Usuario</label>
                            <input type="text" class="form-control" id="txtusuario" name="txtusuario" value="${emp.getUsuario()}" required="true">
                        </div>
                        <div class="mb-3">
                            <label for="txtclave" class="form-label">Clave</label>
                            <input type="password" class="form-control" id="txtclave" name="txtclave" required="true" value="${emp.getClave()}">
                        </div>
                        <div class="mb-3">
                            <label for="txtclaveConfirm" class="form-label">Confirmar Clave</label>
                            <input type="password" class="form-control" id="txtclaveConfirm" name="txtclaveConfirm" required="true">
                        </div>
                         
                            

                        <button type="submit" name="accion" value="Insertar" class="btn btn-success"
                                <c:if test="${emp.getNombre() != null}"><c:out value="disabled='disabled'"/></c:if>">Agregar</button>

                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary" 
                                <c:if test="${emp.getNombre() == null}"><c:out value="disabled='disabled'"/></c:if>">Actualizar</button>
                                
                        <a href="Controlador?menu=Empleado&accion=Cancelar" class="btn btn-danger">Cancelar</a>

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
                                <th class="text-center text-light">C�dula</th>
                                <th class="text-center text-light">Direcci�n</th>
                                <th class="text-center text-light">Tel�fono</th>
                                <th class="text-center text-light">Usuario</th>
                                <th class="text-center text-light">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="em" items="${empleado}">
                            <tr>
                                <td class="text-center">${em.getId()}</td>
                                <td class="text-center">${em.getNombre()}</td>
                                <td class="text-center">${em.getApellido()}</td>
                                <td class="text-center">${em.getCi()}</td>
                                <td class="text-center">${em.getDireccion()}</td>
                                <td class="text-center">${em.getTelefono()}</td>
                                <td class="text-center">${em.getUsuario()}</td>
                                <td class="text-center">
                                    <a href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}" class="btn btn-danger" >Eliminar</a>
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
                            <c:if test="${mensaje == 2}">
                                <div id="mensaje" class="alert alert-danger" style="position:absolute; top: 12px; right: 10px;"" role="alert">
                                    Contrase�as no coinciden
                                    <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-danger btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                                </div>
                            </c:if>

        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
