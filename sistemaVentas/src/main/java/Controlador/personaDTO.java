/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.empleadoDAO;
import Modelo.personaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
public class personaDTO extends HttpServlet {

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
            personaDAO dao = new personaDAO();
            empleadoDAO daoempleado = new empleadoDAO();
            
            
            if (accion.equalsIgnoreCase("listar")) {
                
                
                
            } else if (accion.equalsIgnoreCase("agregar")) {
                String nombre = request.getParameter("txtnombre");
                String apellido = request.getParameter("txtapellido");
                int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                String direccion = request.getParameter("txtdireccion");
                String telefono = request.getParameter("txttelefono");
                
                // seteamos los datos que obtenemos con el getParameter
                dao.setNombre(nombre);
                dao.setApellido(apellido);
                dao.setCedula(cedula);
                dao.setDireccion(direccion);
                dao.setTelefono(telefono);
                dao.insertarPersonas();
                
//                rs = daoempleado.ultimoId_persona();
//                request.setAttribute("datos", rs);
//                while (rs.next()) {
//                    System.out.println(rs.getInt("ultimo_id_persona"));
//                }
                
                String seleccionado = request.getParameter("seleccionado");
                
                switch (seleccionado) {
                    case "empleado":
                        response.sendRedirect("agregarEmpleado.jsp");
                        break;
                    case "proveedor":
                        response.sendRedirect("agregarProveedor.jsp");
                        break;
                    case "cliente":
                        response.sendRedirect("agregarCliente.jsp");
                        break;
                    default:
                        break;
                }
                
               
            } else if (accion.equalsIgnoreCase("eliminar")) {
                
                
                
            } else if (accion.equalsIgnoreCase("editar_listar")) { 
                
                
                
            } else if (accion.equalsIgnoreCase("editar")) {
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
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
