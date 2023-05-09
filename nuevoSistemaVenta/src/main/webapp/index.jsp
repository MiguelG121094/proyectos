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
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- fondo -->
        <link href="img/fondo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    
                    <form method="POST" action="validar" class="form-sign" >
                        <div class="form-group text-center">
                            <h1>Login</h1>
                                <img src="img/usuario.jpg" alt="70" width="120"/>
                                <br>
                                <label>Sistema Compra/Venta</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtusuario" class="form-control" required="true" placeholder="Ingrese su Usuario">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="txtclave" class="form-control" required="true" placeholder="Ingrese su Contraseña">
                        </div>
                        <button id="btnIngresar" type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">Ingresar</button>
                    </form>
                    
                </div>
                <div class="form-group">
                    <a href="manualUsuario/manual_de_usuario.pdf" target="_blank" style="float: right;">Manual de usuario</a>
                </div>
            </div>
        </div>
        
                    
        
        <c:if test="${mensaje == 0}">
                        <div id="mensaje" class="alert alert-danger" style="position:absolute; top: 10px; right: 10px;" role="alert">
                        Usuario o contraseña incorrecta
                        <button type="button" style="border: none; float:right; display:inline-block; padding:0px 5px;" class="btn btn-outline-danger btn-close" data-bs-dismiss="alert" aria-label="Close"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button>
                    </div>
                    </c:if>
                        <script>
                            setTimeout("document.getElementById('mensaje').style.visibility='hidden'",5000);
                        </script>
                        
                        
                        
                        
                        
        
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
