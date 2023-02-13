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
public class personaDAO {
    ResultSet rs;
    int id_persona;
    String nombre;
    String apellido;
    int cedula;
    String direccion;
    String telefono;

    //constructores
    public personaDAO() {
    }

    public personaDAO(int id_persona, String nombre, String apellido, int cedula, String direccion, String telefono) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
    //getters y setters

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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
    
    
    //METODOS
    public void insertarPersonas(){
        try {
//            gbl.cx.insertarEmpleado("CALL `sp_agregarPersona`(?,?,?,?,?)", this.getNombre(), 
//                                                                            this.getApellido(), 
//                                                                            this.getCedula(), 
//                                                                            this.getDireccion(),
//                                                                            this.getTelefono());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    
}
