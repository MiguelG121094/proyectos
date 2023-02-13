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
public class clienteDAO {

    ResultSet rs;
    int id_cliente;
    String nombre;
    String apellido;
    int cedula;
    String direccion;
    String telefono;
    String ruc;

    public clienteDAO() {
    }

    public clienteDAO(int id_cliente, String nombre, String apellido, int cedula, String direccion, String telefono, String ruc) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public ResultSet cargaCliente() {
        try {
            rs = gbl.cx.cargaEmpleado("CALL `sp_cargarCliente`;");
        } catch (Exception ex) {
            System.out.println("El error es: " + ex);
        }
        return rs;
    }

    public void insertarCliente() {
        try {
            gbl.cx.insertarCliente("CALL `sp_insertarCliente`(?,?,?,?,?,?)", this.getNombre(),
                    this.getApellido(),
                    this.getCedula(),
                    this.getDireccion(),
                    this.getTelefono(),
                    this.getRuc());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }

    public void eliminarCliente() {
        try {
            gbl.cx.eliminarCliente("CALL `sp_eliminarCliente`(?)", this.getId_cliente());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }

    public ResultSet cargaCliente_id() {
        try {
            rs = gbl.cx.cargaCliente_id("CALL sp_cargaCliente_id(?)", getId_cliente());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }

    public void editarCliente() {
        try {
            gbl.cx.editarCliente("CALL `sp_editarCliente`(?,?,?,?,?,?,?)", this.getId_cliente(),
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
