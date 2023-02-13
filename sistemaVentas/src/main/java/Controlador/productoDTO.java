/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.productoDAO;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
public class productoDTO extends HttpServlet {

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
            
            productoDAO dao = new productoDAO();
            
            if (accion.equalsIgnoreCase("listar")) {
                rs = dao.cargaProducto();
                request.setAttribute("datosProducto", rs);
                request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("agregar")) {
                String descripcion = request.getParameter("txtdescripcion");
                int precio_compra = Integer.parseInt(request.getParameter("txtprecio_compra"));
                int precio_venta = Integer.parseInt(request.getParameter("txtprecio_venta"));
                int cantidad_minima = Integer.parseInt(request.getParameter("txtcantidad_minima"));
                
                dao.setDescripcion(descripcion);
                dao.setPro_precio_compra(precio_compra);
                dao.setPro_precio_venta(precio_venta);
                dao.setCantidad_minima(cantidad_minima);
                dao.insertarProducto();
                
                response.sendRedirect("productoDTO?accion=listar");
                
                
            } else if (accion.equalsIgnoreCase("eliminar")) {
                int id_producto = Integer.parseInt(request.getParameter("id"));
                dao.setId_producto(id_producto);
                dao.eliminarProducto();
                
                response.sendRedirect("productoDTO?accion=listar");
                
                
            } else if (accion.equalsIgnoreCase("editar_listar")) { 
                int id_producto = Integer.parseInt(request.getParameter("id"));
                dao.setId_producto(id_producto);
                rs = dao.cargaProducto_id();
                request.setAttribute("datos", rs);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
                
                
            } else if (accion.equalsIgnoreCase("editar")) {
                int id_producto = Integer.parseInt(request.getParameter("txtid"));
                String descripcion = request.getParameter("txtdescripcion");
                int precio_compra = Integer.parseInt(request.getParameter("txtprecio_compra"));
                int precio_venta = Integer.parseInt(request.getParameter("txtprecio_venta"));
                int cantidad_minima = Integer.parseInt(request.getParameter("txtcantidad_minima"));
                
                dao.setId_producto(id_producto);
                dao.setDescripcion(descripcion);
                dao.setPro_precio_compra(precio_compra);
                dao.setPro_precio_venta(precio_venta);
                dao.setCantidad_minima(cantidad_minima);
                dao.editarProducto();
                
                response.sendRedirect("productoDTO?accion=listar");
                
                
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
