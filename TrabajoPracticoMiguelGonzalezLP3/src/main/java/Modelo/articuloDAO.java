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
public class articuloDAO {
    ResultSet rs;
    int id_articulo;
    String nombre;
    String marca;
    int id_deposito;

    public articuloDAO() {
    }

    public articuloDAO(ResultSet rs, int id_articulo, String nombre, String marca, int id_deposito) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.marca = marca;
        this.id_deposito = id_deposito;
    }

    public int getId_deposito() {
        return id_deposito;
    }

    public void setId_deposito(int id_deposito) {
        this.id_deposito = id_deposito;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //Metodos
    public ResultSet cargarArticulo(){
        try {
            rs = gbl.cx.cargaArticulos("CALL `sp_cargaArticulo_id_deposito`");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        
        return rs;
    }
    
    public void eliminarArticulo(){
        try {
            gbl.cx.eliminarArticulo("CALL `sp_eliminarArticulo`(?)", this.getId_articulo());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void agregarArticulo(){
        try {
            gbl.cx.insertarArticulo("CALL `sp_insertarArticulo`(?,?,?)", this.getNombre() ,this.getMarca(), this.getId_deposito());
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public ResultSet cargaDepositos(){
        try {
            rs = gbl.cx.cargaDepositos("CALL `sp_cargaDepositos`");
        } catch (Exception e) {
            System.out.println("Error: " +e);
        }
        return rs;
    }
    
    
}
