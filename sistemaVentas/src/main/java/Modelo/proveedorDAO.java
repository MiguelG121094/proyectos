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
public class proveedorDAO {
    ResultSet rs;
    int id_proveedor;
    String nombre;
    String apellido;
    int cedula;
    String direccion;
    String telefono;
    String ruc;

    public proveedorDAO() {
    }

    public proveedorDAO(int id_proveedor, String nombre, String apellido, int cedula, String direccion, String telefono, String ruc) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    
    public ResultSet cargaProveedor(){
        try {
            rs = gbl.cx.cargaProveedor("CALL `sp_cargarProveedor`;");
        } catch (Exception ex) {
            System.out.println("El error es: "+ex);
        }
        return rs;
    }
    
    public void insertarProveedor() {
        try {
            gbl.cx.insertarCliente("CALL `sp_insertarProveedor`(?,?,?,?,?,?)", this.getNombre(),
                    this.getApellido(),
                    this.getCedula(),
                    this.getDireccion(),
                    this.getTelefono(),
                    this.getRuc());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public void eliminarProveedor() {
        try {
            gbl.cx.eliminarProveedor("CALL `sp_eliminarProveedor`(?)", this.getId_proveedor());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet cargaProveedor_id() {
        try {
            rs = gbl.cx.cargaProveedor_id("CALL sp_cargaProveedor_id(?)", this.getId_proveedor());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }
    
    public void editarProveedor() {
        try {
            gbl.cx.editarProveedor("CALL `sp_editarProveedor`(?,?,?,?,?,?,?)", this.getId_proveedor(),
                                                                                this.getNombre(),
                                                                                this.getApellido(),
                                                                                this.getCedula(),
                                                                                this.getDireccion(),
                                                                                this.getTelefono(),
                                                                                this.getRuc());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    
    
    
    
    
    
    
}
