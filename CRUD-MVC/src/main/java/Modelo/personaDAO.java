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
    String cedula;
    String nombre;
    String apellido;
    int id_ciudad;

    //cuando hay mas constructores con y sin parametros se lo llama constructor sobrecargado
    //construcctor sin parametros
    public personaDAO() {
    }

    //construcctor con parametros
    public personaDAO(ResultSet rs, int id_persona, String cedula, String nombre, String apellido) {
        this.id_persona = id_persona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    
    
    //METODOS
    public ResultSet cargaPersonas(){
        try {
            rs = gbl.cx.cargaPersonas("CALL `sp_cargaPersonas`;");
        } catch (Exception ex) {
            System.out.println("El error es: "+ex);
        }
        return rs;
    }
    
    public void insertarPersonas(){
        try {
            gbl.cx.insertarPersonas("CALL `sp_insertarPersona`(?,?,?,?,?)", "I", this.getCedula(), 
                                                                                 this.getNombre(), 
                                                                                 this.getApellido(), 
                                                                                 this.getId_ciudad() );
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public void eliminarPersona(){
        try {
            gbl.cx.eliminarPersona("CALL `sp_eliminarPersona`(?)", this.getId_persona());
            System.out.println("Persona eliminada: " + this.getId_persona());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet cargaPersonas_id(){
        try {
            rs = gbl.cx.cargaPersonas_id("CALL sp_cargaPersonas_id(?)", getId_persona());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }
    
    public void editarPersona(){
        try {
            gbl.cx.editarPersona("CALL `sp_editarPersona`(?,?,?,?)", this.getId_persona(),
                                                                     this.getCedula(),
                                                                     this.getNombre(),
                                                                     this.getApellido());
            //System.out.println("Persona editada: " + this.getId_persona());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
        public ResultSet cargaCiudades(){
        try {
            rs = gbl.cx.cargaCiudades("CALL sp_cargaCiudades2");
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }
    
}
