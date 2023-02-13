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
public class productoDAO {

    ResultSet rs;
    int id_producto;
    String descripcion;
    int pro_precio_compra;
    int pro_precio_venta;
    int cantidad_minima;

    public productoDAO() {
    }

    public productoDAO(int id_producto, String descripcion, int pro_precio_compra, int pro_precio_venta, int cantidad_minima) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.pro_precio_compra = pro_precio_compra;
        this.pro_precio_venta = pro_precio_venta;
        this.cantidad_minima = cantidad_minima;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPro_precio_compra() {
        return pro_precio_compra;
    }

    public void setPro_precio_compra(int pro_precio_compra) {
        this.pro_precio_compra = pro_precio_compra;
    }

    public int getPro_precio_venta() {
        return pro_precio_venta;
    }

    public void setPro_precio_venta(int pro_precio_venta) {
        this.pro_precio_venta = pro_precio_venta;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public ResultSet cargaProducto() {
        try {
            rs = gbl.cx.cargaProducto("CALL `sp_cargarProducto`;");
        } catch (Exception ex) {
            System.out.println("El error es: " + ex);
        }
        return rs;
    }

    public void insertarProducto() {
        try {
            gbl.cx.insertarProducto("CALL `sp_insertarProducto`(?,?,?,?)", this.getDescripcion(),
                    this.getPro_precio_compra(),
                    this.getPro_precio_venta(),
                    this.getCantidad_minima());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }

    public void eliminarProducto() {
        try {
            gbl.cx.eliminarProducto("CALL `sp_eliminarProducto`(?)", this.getId_producto());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }

    public ResultSet cargaProducto_id() {
        try {
            rs = gbl.cx.cargaProducto_id("CALL sp_cargaProducto_id(?)", this.getId_producto());
        } catch (Exception e) {
            System.out.println("El error es: " + e);
        }
        return rs;
    }

    public void editarProducto() {
        try {
            gbl.cx.editarProducto("CALL `sp_editarProducto`(?,?,?,?,?)", this.getId_producto(),
                    this.getDescripcion(),
                    this.getPro_precio_compra(),
                    this.getPro_precio_venta(),
                    this.getCantidad_minima());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }

}
