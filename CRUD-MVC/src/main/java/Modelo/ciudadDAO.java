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
public class ciudadDAO {
    ResultSet rs;
    int id_ciudad;
    String descripcion;

    //cuando hay mas constructores con y sin parametros se lo llama constructor sobrecargado
    //construcctor sin parametros
    public ciudadDAO() {
    }

    //construcctor con parametros
    public ciudadDAO(ResultSet rs, int id_persona, String descripcion) {
        this.id_ciudad = id_persona;
        this.descripcion = descripcion;
    }


    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



  
    //METODOS PARA CIUDAD
    public ResultSet cargaCiudades2(){
        try {
            rs = gbl.cx.cargaCiudades("CALL `sp_cargaCiudades`");
        } catch (Exception ex) {
            System.out.println("El error es: "+ex);
        }
        return rs;
    }
    
    public void insertarCiudad(){
        try {
            gbl.cx.insertarCiudad("CALL `sp_insertarCiudad`(?)", this.getDescripcion());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public void eliminarCiudad(){
        try {
            gbl.cx.eliminarCiudad("CALL `sp_eliminarCiudad`(?)", this.getId_ciudad());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet cargaCiudad_id(){
        try {
            rs = gbl.cx.cargaCiudad_id("CALL sp_cargaCiudad_id(?)", this.getId_ciudad());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }
    
    public void editarCiudad(){
        try {
            gbl.cx.editarCiudad("CALL `sp_editarCiudad`(?,?)", this.getId_ciudad(),
                                                               this.getDescripcion());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
}
