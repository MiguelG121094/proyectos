/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.clienteDAO;
import Modelo.productoDAO;
import Modelo.ventaDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ventaDTO extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            ResultSet rs;
            ResultSet rs2;
            ResultSet rs3;
            ResultSet rs4;
            
            ventaDAO dao = new ventaDAO();
            clienteDAO daoCliente = new clienteDAO();
            productoDAO daoProducto = new productoDAO();
            
            if (accion.equalsIgnoreCase("listar")) {
                rs = daoCliente.cargaCliente();
                rs2 = daoProducto.cargaProducto();
                request.setAttribute("datosCliente", rs);
                request.setAttribute("datosProducto", rs2);
//                rs3 = daoCliente.cargaCliente_id();
//                request.setAttribute("datosCliente_id", rs3);
                request.getRequestDispatcher("generarVenta.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("listarProducto")) {
                rs = daoProducto.cargaProducto();
                request.setAttribute("datosProducto", rs);
                
                
            } else if (accion.equalsIgnoreCase("cargar_cliente")) {
                int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
                daoCliente.setId_cliente(id_cliente);
                rs3 = daoCliente.cargaCliente_id();
                
                
                rs = daoCliente.cargaCliente();
                rs2 = daoProducto.cargaProducto();
                request.setAttribute("datosCliente", rs);
                request.setAttribute("datosProducto", rs2);
                request.setAttribute("datosCliente_id", rs3);
                request.getRequestDispatcher("nuevaVenta.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("cargar_producto")) {
                int id_producto = Integer.parseInt(request.getParameter("id_producto"));
                daoProducto.setId_producto(id_producto);
                rs4 = daoProducto.cargaProducto_id();
                
                rs = daoCliente.cargaCliente();
                rs2 = daoProducto.cargaProducto();
                //rs3 = daoCliente.cargaCliente_id();
                request.setAttribute("datosCliente", rs);
                request.setAttribute("datosProducto", rs2);
                //request.setAttribute("datosCliente_id", rs3);
                request.setAttribute("datosProducto_id", rs4);
                request.getRequestDispatcher("generarVenta.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("agregarDatos_DetVenta")) {
                int id_producto = Integer.parseInt(request.getParameter("txtidProducto"));
                int precio_venta = Integer.parseInt(request.getParameter("txtprecio_venta"));
                String cantidad = request.getParameter("txtcantidad");
                System.out.println(id_producto);
                System.out.println(precio_venta);
                System.out.println(cantidad);
                
                ResultSet rs5 = dao.ultimoId_cab_venta();
                int ultimoId_cab_venta = 0;
                dao.setId_empleado(ultimoId_cab_venta);
                
                try {
                    while (rs5.next()) {
                    ultimoId_cab_venta = rs5.getInt("id_cab_venta");
                    System.out.println("Dentro Try: El valor de id cab venta es: " + ultimoId_cab_venta);
                    break;
                }
                } catch (SQLException ex) {
                    System.out.println("Error: "+ex);
                }
                
                System.out.println(" Fuera del try cath: El valor de id cab venta es: " + ultimoId_cab_venta);
                
                
            } else if (accion.equalsIgnoreCase("eliminar")) {
                
                
                
                
            } else if (accion.equalsIgnoreCase("eliminarProducto")) {
                
                
                
            }else if (accion.equalsIgnoreCase("editar_listar")) { 
                
                
                
            } else if (accion.equalsIgnoreCase("editar")) {
                
                
                
            }
            
            
        } catch (IOException | NumberFormatException | ServletException e) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ventaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ventaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
