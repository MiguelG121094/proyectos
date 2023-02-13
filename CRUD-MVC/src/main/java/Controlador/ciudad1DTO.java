/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.ciudadDAO;
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
public class ciudad1DTO extends HttpServlet {

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
        try{
            String accion = request.getParameter("accion");
            ResultSet rs;
            ciudadDAO dao = new ciudadDAO();
            if (accion.equalsIgnoreCase("listar")) {
                rs = dao.cargaCiudades2();
                request.setAttribute("datos", rs);
                request.getRequestDispatcher("listarCiudad.jsp").forward(request, response);
                
                
            } else if (accion.equalsIgnoreCase("agregar")) {
                String descripcion = request.getParameter("txtdescripcion");
                dao.setDescripcion(descripcion);
                dao.insertarCiudad();
                
                response.sendRedirect("ciudad1DTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("eliminar")) {
                int id_ciudad = Integer.parseInt(request.getParameter("id"));
                dao.setId_ciudad(id_ciudad);
                dao.eliminarCiudad();
                
                response.sendRedirect("ciudad1DTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("editar_listar")) {
                String id_ciudad = request.getParameter("id");
                int id_ciu = Integer.parseInt(id_ciudad);
                dao.setId_ciudad(id_ciu);
                rs = dao.cargaCiudad_id();
                request.setAttribute("datos", rs);
                request.getRequestDispatcher("editarCiudad.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("editar")) { //UPDATE
                String id_ciudad = request.getParameter("txtid");
                int id_ciu = Integer.parseInt(id_ciudad);
                String descripcion = request.getParameter("txtdescripcion");
                
                dao.setId_ciudad(id_ciu);
                dao.setDescripcion(descripcion);
                dao.editarCiudad();
                
                response.sendRedirect("ciudad1DTO?accion=listar");
                
            }
        }catch(IOException | NumberFormatException | ServletException ex){
            System.out.println("Error: "+ex);
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
