/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public int traerUltimo_id_venta() {
        int ultimo_id_venta = 0;
        String sql = "SELECT MAX(id_cab_venta) FROM cabecera_venta;";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ultimo_id_venta = rs.getInt(1);
            }

        } catch (Exception e) {
        }

        return ultimo_id_venta;
    }

    public int guardarCab_Venta(Venta ve) {
        String sql = "insert into cabecera_venta(fecha_venta, id_cliente, id_empleado, estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ve.getFecha());
            ps.setInt(2, ve.getId_cliente());
            ps.setInt(3, ve.getId_empleado());
            ps.setString(4, ve.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public int guardarDet_Venta(Venta venta) {
        String sql = "insert into detalle_venta(id_cab_venta, precio_venta, cantidad, id_producto) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId_venta());
            ps.setInt(2, venta.getPrecio());
            ps.setInt(3, venta.getCantidad());
            ps.setInt(4, venta.getId_producto());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return r;
    }

    public List listarVentas() {
        String sql = "SELECT a.`id_cab_venta`, b.`nombre` AS nombreCliente, GROUP_CONCAT(DISTINCT d.`descripcion`) AS descriProducto,\n"
                + "SUM(c.`precio_venta` * c.`cantidad`) AS subtotal, a.`fecha_venta` AS fechaVenta FROM `cabecera_venta` a \n"
                + "JOIN `cliente` b ON a.`id_cliente` = b.`id_cliente` \n"
                + "JOIN `detalle_venta` c ON c.`id_cab_venta` = c.`id_cab_venta` \n"
                + "JOIN `producto` d ON c.`id_producto` = d.`id_producto` \n"
                + "WHERE a.`id_cab_venta` = c.`id_cab_venta` \n"
                + "GROUP BY a.`id_cab_venta`,c.`id_cab_venta` \n"
                + "ORDER BY a.`id_cab_venta` DESC LIMIT 0, 5;";
        List<Venta> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setId_venta(Integer.parseInt(rs.getString(1)));
                v.setNombre_cliente(rs.getString(2));
                v.setDescripcion(rs.getString(3));
                v.setMonto(Integer.parseInt(rs.getString(4)));
                v.setFecha(rs.getString(5));
                //String[] value = new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                lista.add(v);

            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    public int cantidadStock(int id_producto) {
        int cantidadStock = 0;
        String sql = "SELECT `cantidad_minima` FROM `producto` WHERE `id_producto` = " + id_producto;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidadStock = rs.getInt(1);
            }

        } catch (Exception e) {
        }

        return cantidadStock;
    }
    
    
    public int descontarStock(Venta v) {
        String sql = "update producto set cantidad_minima=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getStockActual());
            ps.setInt(2, v.getId_producto());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

}
