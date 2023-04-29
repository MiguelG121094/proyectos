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

/**
 *
 * @author Miguel
 */
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    //CRUD
    public List listar() {
        String sql = "CALL `sp_cargarCliente`";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCi(rs.getInt(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setRuc(rs.getString(7));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int insertar(Cliente c) {
        String sql = "insert into cliente(nombre, apellido, ci, direccion, telefono, ruc) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setInt(3, c.getCi());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getRuc());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Cliente listar_id(int id) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where id_cliente ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCi(rs.getInt(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setRuc(rs.getString(7));

            }

        } catch (Exception e) {
        }
        return c;
    }

    public int editar(Cliente c) {
        String sql = "update cliente set nombre=?, apellido=?, ci=?, direccion=?, telefono=?, ruc=? where id_cliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setInt(3, c.getCi());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getRuc());
            ps.setInt(7, c.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void borrar(int id) {
        String sql = "delete from cliente where id_cliente = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void vaciarCliente(){
        Cliente c = new Cliente();
                c.setId(0);
                c.setNombre("");
                c.setApellido("");
                c.setCi(0);
                c.setDireccion("");
                c.setTelefono("");
                c.setRuc("");
    }
    
    
}
