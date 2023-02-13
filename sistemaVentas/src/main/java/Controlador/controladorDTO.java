/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.clienteDAO;
import Modelo.loginDAO;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel
 */
public class controladorDTO extends HttpServlet {
    
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

            loginDAO daoLogin = new loginDAO();
            clienteDAO daoCliente = new clienteDAO();

            if (accion.equalsIgnoreCase("login")) {
                
                String usuario = request.getParameter("txtusuario");
                String clave = request.getParameter("txtclave");
                
                daoLogin.setUsuario(usuario);
                daoLogin.setClave(clave);
                rs = daoLogin.logueo();
                request.setAttribute("datos", rs);
                int contar;
                if (rs.next()) {
                    contar = rs.getInt("contar");
                    if (contar > 0) {
                        //menu
                        HttpSession sesion  = request.getSession();
                        sesion.setAttribute("contar", contar);
                        sesion.setAttribute("usuario", usuario);
                        
                        response.sendRedirect("menuPrincipal.jsp");

                        //request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
                    }else{
                        //error
                        response.sendRedirect("error.jsp");
                    }
                }else{
                    response.sendRedirect("index.jsp");
                }
                
            }
            if (accion.equalsIgnoreCase("buscarCliente")) {
                int id_cliente = Integer.parseInt(request.getParameter("txtidCliente"));
                daoCliente.setId_cliente(id_cliente);
                rs = daoCliente.cargaCliente_id();
                request.setAttribute("datos", rs);
                
                response.sendRedirect("nuevaVenta.jsp");
                
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Error: "+ e);
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
