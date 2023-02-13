/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.personaDAO;
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
        try{
            String accion = request.getParameter("accion");
            ResultSet rs;
            personaDAO dao = new personaDAO();
            if (accion.equalsIgnoreCase("agregar")) { //CREATE
                String cedula = request.getParameter("txtcedula");
                String nombre = request.getParameter("txtnombre");
                String apellido = request.getParameter("txtapellido");
                int id_cedula = Integer.parseInt(request.getParameter("cbociudad"));
                
                // seteamos los datos que obtenemos con el getParameter
                dao.setCedula(cedula);
                dao.setNombre(nombre);
                dao.setApellido(apellido);
                dao.setId_ciudad(id_cedula);
                dao.insertarPersonas();
                
                //response.sendRedirect("index.jsp"); //le decimos que si inserta todo bien que redireccione al index
                response.sendRedirect("personaDTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("listar")) { //READ
                rs = dao.cargaPersonas();
                request.setAttribute("datos", rs); //aqui enviamos el valor de rs con un nombre de variable que es datos y le pasamos a la vista
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("eliminar")) { //DELETE
                String id_persona = request.getParameter("id");
                int id_per = Integer.parseInt(id_persona);
                dao.setId_persona(id_per);
                dao.eliminarPersona();
                
                response.sendRedirect("personaDTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("editar_listar")) { //UPDATE
                String id = request.getParameter("id");
                int id_per = Integer.parseInt(id);
                dao.setId_persona(id_per);
                rs = dao.cargaPersonas_id();
                request.setAttribute("datos", rs);
                //response.sendRedirect("editar.jsp");
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
            } else if (accion.equalsIgnoreCase("editar")) { //UPDATE
                String id = request.getParameter("txtid");
                int id_per = Integer.parseInt(id);
                String cedula = request.getParameter("txtcedula");
                String nombre = request.getParameter("txtnombre");
                String apellido = request.getParameter("txtapellido");
                
                dao.setId_persona(id_per);
                dao.setCedula(cedula);
                dao.setNombre(nombre);
                dao.setApellido(apellido);
                dao.editarPersona();
                
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("personaDTO?accion=listar");
                
            } else if (accion.equalsIgnoreCase("combo")) { //cargar combo de ciudades
                rs = dao.cargaCiudades();
                request.setAttribute("combo", rs);
                request.getRequestDispatcher("agregar.jsp").forward(request, response);
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
