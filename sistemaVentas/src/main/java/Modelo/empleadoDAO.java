/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.gbl;
import java.sql.ResultSet;

/**
 *
 * @author Miguel
 */
public class empleadoDAO {
    ResultSet rs;
    int id_empleado;
    String nombre;
    String apellido;
    int cedula;
    String direccion;
    String telefono;
    String usuario;
    String clave;

    //constructores
    public empleadoDAO(){
    }

    public empleadoDAO (int id_persona, String nombre, String apellido, int cedula, String direccion, String telefono, String usuario, String clave) {
        this.id_empleado = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    
    //getters y setters

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
    //METODOS
    public ResultSet cargaEmpleado(){
        try {
            rs = gbl.cx.cargaEmpleado("CALL `sp_cargarEmpleado`;");
        } catch (Exception ex) {
            System.out.println("El error es: "+ex);
        }
        return rs;
    }
    
    public void insertarEmpleado(){
        try {
            gbl.cx.insertarEmpleado("CALL `sp_insertarEmpleado`(?,?,?,?,?,?,?)", this.getNombre(), 
                                                                            this.getApellido(), 
                                                                            this.getCedula(), 
                                                                            this.getDireccion(),
                                                                            this.getTelefono(),
                                                                            this.getUsuario(),
                                                                            this.getClave());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public void eliminarEmpleado(){
        try {
            gbl.cx.eliminarEmpleado("CALL `sp_eliminarEmpleado`(?)", this.getId_empleado());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet cargaEmpleado_id(){
        try {
            rs = gbl.cx.cargaEmpleado_id("CALL sp_cargaEmpleado_id(?)", getId_empleado());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }
    
    public void editarEmpleado(){
        try {
            gbl.cx.editarEmpleado("CALL `sp_editarEmpleado`(?,?,?,?,?,?,?,?)", this.getId_empleado(),
                                                                                   this.getNombre(), 
                                                                                   this.getApellido(), 
                                                                                   this.getCedula(), 
                                                                                   this.getDireccion(),
                                                                                   this.getTelefono(),
                                                                                   this.getUsuario(),
                                                                                   this.getClave());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet obtenerId_empleado_user() {
        try {
            rs = gbl.cx.obtenerId_empleado_user("CALL `sp_obtenerId_empleado_user`(?);", this.getUsuario());
        } catch (Exception ex) {
            System.out.println("El error es: " + ex);
        }
        return rs;
    }
    
    
}
