/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.proveedorDAO;
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
public class proveedorDTO extends HttpServlet {

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

            proveedorDAO dao = new proveedorDAO();

            if (accion.equalsIgnoreCase("listar")) {
                rs = dao.cargaProveedor();
                request.setAttribute("datos", rs);
                request.getRequestDispatcher("listarProveedor.jsp").forward(request, response);

            } else if (accion.equalsIgnoreCase("agregar")) {
                String nombre = request.getParameter("txtnombre");
                String apellido = request.getParameter("txtapellido");
                int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                String direccion = request.getParameter("txtdireccion");
                String telefono = request.getParameter("txttelefono");
                String ruc = request.getParameter("txtruc");

                dao.setNombre(nombre);
                dao.setApellido(apellido);
                dao.setCedula(cedula);
                dao.setDireccion(direccion);
                dao.setTelefono(telefono);
                dao.setRuc(ruc);
                dao.insertarProveedor();

                response.sendRedirect("proveedorDTO?accion=listar");

            } else if (accion.equalsIgnoreCase("eliminar")) {
                int id_proveedor = Integer.parseInt(request.getParameter("id"));
                dao.setId_proveedor(id_proveedor);
                dao.eliminarProveedor();

                response.sendRedirect("proveedorDTO?accion=listar");

            } else if (accion.equalsIgnoreCase("editar_listar")) {
                int id_proveedor = Integer.parseInt(request.getParameter("id"));
                dao.setId_proveedor(id_proveedor);
                rs = dao.cargaProveedor_id();
                request.setAttribute("datos", rs);
                request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);

            } else if (accion.equalsIgnoreCase("editar")) {
                int id_proveedor = Integer.parseInt(request.getParameter("txtid"));
                String nombre = request.getParameter("txtnombre");
                String apellido = request.getParameter("txtapellido");
                int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                String direccion = request.getParameter("txtdireccion");
                String telefono = request.getParameter("txttelefono");
                String ruc = request.getParameter("txtruc");

                dao.setId_proveedor(id_proveedor);
                dao.setNombre(nombre);
                dao.setApellido(apellido);
                dao.setCedula(cedula);
                dao.setDireccion(direccion);
                dao.setTelefono(telefono);
                dao.setRuc(ruc);
                dao.editarProveedor();

                response.sendRedirect("proveedorDTO?accion=listar");

            }

        } catch (IOException | ServletException e) {
            System.out.println("Error: " + e);
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
