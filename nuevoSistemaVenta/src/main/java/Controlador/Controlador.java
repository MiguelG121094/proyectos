/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int id_em;

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int id_c;

    Proveedor p = new Proveedor();
    ProveedorDAO pdao = new ProveedorDAO();
    int id_p;

    Producto produc = new Producto();
    ProductoDAO producdao = new ProductoDAO();
    int id_produc;

    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();
    List<Venta> listaVenta = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    int precio;
    int cant;
    int subTotal;
    int totalPagar;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equalsIgnoreCase("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleado", lista);
                    break;
                case "Insertar":
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion = request.getParameter("txtdireccion");
                    String telefono = request.getParameter("txttelefono");
                    String usuario = request.getParameter("txtusuario");
                    String clave = request.getParameter("txtclave");
                    em.setNombre(nombre);
                    em.setApellido(apellido);
                    em.setCi(cedula);
                    em.setDireccion(direccion);
                    em.setTelefono(telefono);
                    em.setUsuario(usuario);
                    em.setClave(clave);
                    edao.insertar(em);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    id_em = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listar_id(id_em);
                    request.setAttribute("emp", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String apellido1 = request.getParameter("txtapellido");
                    int cedula1 = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion1 = request.getParameter("txtdireccion");
                    String telefono1 = request.getParameter("txttelefono");
                    String usuario1 = request.getParameter("txtusuario");
                    String clave1 = request.getParameter("txtclave");
                    em.setNombre(nombre1);
                    em.setApellido(apellido1);
                    em.setCi(cedula1);
                    em.setDireccion(direccion1);
                    em.setTelefono(telefono1);
                    em.setUsuario(usuario1);
                    em.setClave(clave1);
                    em.setId(id_em);
                    edao.editar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    id_em = Integer.parseInt(request.getParameter("id"));
                    edao.borrar(id_em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("cliente", lista);
                    break;
                case "Insertar":
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion = request.getParameter("txtdireccion");
                    String telefono = request.getParameter("txttelefono");
                    String ruc = request.getParameter("txtruc");
                    c.setNombre(nombre);
                    c.setApellido(apellido);
                    c.setCi(cedula);
                    c.setDireccion(direccion);
                    c.setTelefono(telefono);
                    c.setRuc(ruc);
                    cdao.insertar(c);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    id_c = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = cdao.listar_id(id_c);
                    request.setAttribute("cli", cl);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String apellido1 = request.getParameter("txtapellido");
                    int cedula1 = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion1 = request.getParameter("txtdireccion");
                    String telefono1 = request.getParameter("txttelefono");
                    String ruc1 = request.getParameter("txtruc");
                    c.setNombre(nombre1);
                    c.setApellido(apellido1);
                    c.setCi(cedula1);
                    c.setDireccion(direccion1);
                    c.setTelefono(telefono1);
                    c.setRuc(ruc1);
                    c.setId(id_c);
                    cdao.editar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    id_c = Integer.parseInt(request.getParameter("id"));
                    cdao.borrar(id_c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("proveedor", lista);

                    break;
                case "Insertar":
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion = request.getParameter("txtdireccion");
                    String telefono = request.getParameter("txttelefono");
                    String ruc = request.getParameter("txtruc");
                    p.setNombre(nombre);
                    p.setApellido(apellido);
                    p.setCi(cedula);
                    p.setDireccion(direccion);
                    p.setTelefono(telefono);
                    p.setRuc(ruc);
                    pdao.insertar(p);

                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    id_p = Integer.parseInt(request.getParameter("id"));
                    Proveedor pr = pdao.listar_id(id_p);
                    request.setAttribute("pro", pr);

                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String apellido1 = request.getParameter("txtapellido");
                    int cedula1 = Integer.parseInt(request.getParameter("txtcedula"));
                    String direccion1 = request.getParameter("txtdireccion");
                    String telefono1 = request.getParameter("txttelefono");
                    String ruc1 = request.getParameter("txtruc");
                    p.setNombre(nombre1);
                    p.setApellido(apellido1);
                    p.setCi(cedula1);
                    p.setDireccion(direccion1);
                    p.setTelefono(telefono1);
                    p.setRuc(ruc1);
                    p.setId(id_p);
                    pdao.editar(p);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    id_p = Integer.parseInt(request.getParameter("id"));
                    pdao.borrar(id_p);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = producdao.listar();
                    request.setAttribute("producto", lista);

                    break;
                case "Insertar":
                    String descripcion = request.getParameter("txtdescripcion");
                    int precio_compra = Integer.parseInt(request.getParameter("txtprecio_compra"));
                    int precio_venta = Integer.parseInt(request.getParameter("txtprecio_venta"));
                    int cant_minima = Integer.parseInt(request.getParameter("txtcant_minima"));
                    produc.setDescripcion(descripcion);
                    produc.setPrecio_compra(precio_compra);
                    produc.setPrecio_venta(precio_venta);
                    produc.setCant_minima(cant_minima);
                    producdao.insertar(produc);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    id_produc = Integer.parseInt(request.getParameter("id"));
                    Producto product = producdao.listar_id(id_produc);
                    request.setAttribute("product", product);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":
                    String descripcion1 = request.getParameter("txtdescripcion");
                    int precio_compra1 = Integer.parseInt(request.getParameter("txtprecio_compra"));
                    int precio_venta1 = Integer.parseInt(request.getParameter("txtprecio_venta"));
                    int cant_minima1 = Integer.parseInt(request.getParameter("txtcant_minima"));
                    produc.setDescripcion(descripcion1);
                    produc.setPrecio_compra(precio_compra1);
                    produc.setPrecio_venta(precio_venta1);
                    produc.setCant_minima(cant_minima1);
                    produc.setId(id_produc);
                    producdao.editar(produc);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    id_produc = Integer.parseInt(request.getParameter("id"));
                    producdao.borrar(id_produc);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("RegistrarVenta")) {
            switch (accion) {
                case "ListarModal":
                    String nuevaVenta = request.getParameter("nuevaV");
                    if (nuevaVenta != null) {
                        listaVenta.removeAll(listaVenta);
                        totalPagar = 0;
                        id_em = em.getId();
                    }
                    List lista = cdao.listar();
                    request.setAttribute("cliente", lista);

                    List lista1 = producdao.listar();
                    request.setAttribute("producto", lista1);

                    int idVenta = vdao.traerUltimo_id_venta() + 1;
                    System.out.println("Nro de venta " + idVenta);
                    request.setAttribute("id_venta", idVenta);

                    break;
                case "BuscarCliente":
                    id_c = Integer.parseInt(request.getParameter("idCliente"));
                    c = cdao.listar_id(id_c);
                    request.setAttribute("cli", c);

                    //mantener lista de productos a venderse
                    request.setAttribute("lista", listaVenta);

                    //mantener el total a pagar
                    request.setAttribute("totalpagar", totalPagar);

                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=ListarModal").forward(request, response);

                    break;
                case "BuscarProducto":
                    request.setAttribute("cli", c);
                    id_produc = Integer.parseInt(request.getParameter("idProducto"));
                    Producto product = producdao.listar_id(id_produc);
                    request.setAttribute("product", product);

                    //mantener lista de productos a venderse
                    request.setAttribute("lista", listaVenta);

                    //mantener el total a pagar
                    request.setAttribute("totalpagar", totalPagar);

                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=ListarModal").forward(request, response);

                    break;
                case "Agregar":
                    totalPagar = 0;
                    item = item + 1;
                    cod = Integer.parseInt(request.getParameter("txtidProducto"));
                    descripcion = request.getParameter("txtnombreProducto");
                    precio = Integer.parseInt(request.getParameter("txtprecioVenta"));
                    cant = Integer.parseInt(request.getParameter("txtcantidad"));
                    subTotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setId_producto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubTotal(subTotal);
                    listaVenta.add(v);
                    request.setAttribute("lista", listaVenta);

                    //mantener cliente en la vista
                    if (id_c == 0) {
                        c = cdao.listar_id(id_c = 1);
                    }
                    //c = cdao.listar_id(id_c = 1);
                    request.setAttribute("cli", c);

                    //obtener total a pagar
                    for (int i = 0; i < listaVenta.size(); i++) {
                        totalPagar = totalPagar + listaVenta.get(i).getSubTotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);

                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=ListarModal").forward(request, response);

                    break;
                case "GenerarVenta":
                    //guardar Cabecera venta
                    Date fecha = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    v.setFecha(dateFormat.format(fecha));
                    v.setId_cliente(id_c);
                    v.setId_empleado(id_em);
                    v.setEstado("A");
                    vdao.guardarCab_Venta(v);

                    //Guardar Detalle venta
                    int idCab_venta = vdao.traerUltimo_id_venta();
                    for (int i = 0; i < listaVenta.size(); i++) {
                        v = new Venta();
                        v.setId_venta(vdao.traerUltimo_id_venta());
                        v.setPrecio(listaVenta.get(i).getPrecio());
                        v.setCantidad(listaVenta.get(i).getCantidad());
                        v.setId_producto(listaVenta.get(i).getId_producto());
                        //vdao.guardarDet_Venta(v);
                        
                    }
                    
                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=ListarModal").forward(request, response);

                    break;
                case "Eliminar":
                    for (int i = 0; i < listaVenta.size(); i++) {
                        if (listaVenta.get(i).getId_producto() == id_produc) {
                            listaVenta.remove(i);
                        }
                    }
                    
                    //mantener lista
                    request.setAttribute("lista", listaVenta);

                    //mantener cliente en la vista
                    request.setAttribute("cli", c);
                    
                    //mantener el total a pagar
                    request.setAttribute("totalpagar", totalPagar);
                    
                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=ListarModal").forward(request, response);
                    
                    break;
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        
        if (menu.equals("MenuPrincipal")) {
            switch (accion) {
                case "ListarVentas":
                    List lista = vdao.listarVentas();
                    System.out.println(lista);
                    request.setAttribute("listaVenta", lista);
                    break;
            }
            request.getRequestDispatcher("MenuPrincipal.jsp").forward(request, response);
        }

        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
