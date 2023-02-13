/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.clienteDAO;
import Modelo.empleadoDAO;
import Modelo.productoDAO;
import Modelo.ventasDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
public class ventasDTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            ResultSet rs;
            
            ventasDAO dao = new ventasDAO();
            clienteDAO daoCliente = new clienteDAO();
            empleadoDAO daoEmpleado = new empleadoDAO();
            productoDAO daoProducto = new productoDAO();
            
            if (accion.equalsIgnoreCase("listar")) {
                rs = dao.cargaVenta();
                request.setAttribute("datos", rs);
                
                request.getRequestDispatcher("listarVenta.jsp").forward(request, response);
                
                
            } else if (accion.equalsIgnoreCase("listarCliente")) {
                rs = daoCliente.cargaCliente();
                request.setAttribute("datosCliente", rs);
                
                request.getRequestDispatcher("ventaSeleccionarCliente.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("agregarDatos_CabVenta")) {
                int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
                String usuario = request.getParameter("usuario");
                
                int id_empleado = 0;
                
                daoEmpleado.setUsuario(usuario);
                rs = daoEmpleado.obtenerId_empleado_user();
                while (rs.next()) {
                    id_empleado = rs.getInt("id_empleado");
                }
                
                Date fecha = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dao.setFecha_venta(dateFormat.format(fecha));
                dao.setId_cliente(id_cliente);
                dao.setId_empleado(id_empleado);
                //dao.insertarDatos_cabVenta();
                
                response.sendRedirect("ventaDTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("listarProducto")) {
                rs = daoProducto.cargaProducto();
                request.setAttribute("datosProducto", rs);
                
                request.getRequestDispatcher("ventaSeleccionarProducto.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("agregarDatos_DetVenta")) { 
                int id_producto = Integer.parseInt(request.getParameter("id_producto"));
                int precio_venta = Integer.parseInt(request.getParameter("precio_venta"));
                String cantidad = request.getParameter("txtcantidad");
                //String cantidad = request.getParameter("cantidad");
                System.out.println(cantidad);
                
                ResultSet rs2 = dao.ultimoId_cab_venta();
                int ultimoId_cab_venta = 0;
                dao.setId_empleado(ultimoId_cab_venta);
                
                try {
                    while (rs2.next()) {
                    ultimoId_cab_venta = rs2.getInt("id_cab_venta");
                    System.out.println("Dentro Try: El valor de id cab venta es: " + ultimoId_cab_venta);
                    break;
                }
                } catch (Exception ex) {
                    System.out.println("Error: "+ex);
                }
                
                System.out.println(" Fuera del try cath: El valor de id cab venta es: " + ultimoId_cab_venta);
                int id_cab_venta = rs2.getInt("id_cab_venta");
            } else if (accion.equalsIgnoreCase("editar_listar")) { 
                
                
                
                
            } else if (accion.equalsIgnoreCase("editar")) {
                
                
                
                
            }
            
            
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("Error: "+e);
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
