/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.articuloDAO;
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
public class articuloDTO extends HttpServlet {

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
           
           ResultSet rs, rs2;
           articuloDAO dao = new articuloDAO();
           String accion = request.getParameter("accion");
           
            if (accion.equalsIgnoreCase("combo")) {
                rs = dao.cargaDepositos();
                request.setAttribute("combo", rs);
                rs2 = dao.cargarArticulo();
                request.setAttribute("listar", rs2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("guardar")){
                String nombre = request.getParameter("txtnombre");
                String marca = request.getParameter("txtmarca");
                int id_deposito = Integer.parseInt(request.getParameter("cbodeposito"));
                //rs = dao.cargaDepositos();
                //request.setAttribute("combo", rs);
                
                dao.setNombre(nombre);
                dao.setMarca(marca);
                dao.setId_deposito(id_deposito);
                dao.agregarArticulo();
                rs2 = dao.cargarArticulo();
                rs = dao.cargaDepositos();
                request.setAttribute("combo", rs);
                request.setAttribute("listar", rs2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (accion.equalsIgnoreCase("eliminar")){
                int id_articulo = Integer.parseInt(request.getParameter("id"));
                dao.setId_articulo(id_articulo);
                dao.eliminarArticulo();
                response.sendRedirect("articuloDTO?accion=combo");
            }
           
           
                
        
            
            
        }catch(NumberFormatException ex){
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
