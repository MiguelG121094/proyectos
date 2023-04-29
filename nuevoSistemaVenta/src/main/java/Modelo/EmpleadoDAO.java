/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String usuario, String clave) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE usuario = ? AND clave = ?";
        con = cn.Conexion();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("id_empleado"));
                em.setUsuario(rs.getString("usuario"));
                em.setClave(rs.getString("clave"));
                em.setNombre(rs.getString("nombre"));
                em.setApellido(rs.getString("apellido"));
                em.setDireccion(rs.getString("direccion"));
                em.setTelefono(rs.getString("telefono"));
            }

        } catch (SQLException e) {
        }
        return em;

    }

    //CRUD
    public List listar() {
        String sql = "CALL `sp_cargarEmpleado`";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setCi(rs.getInt(4));
                em.setDireccion(rs.getString(5));
                em.setTelefono(rs.getString(6));
                em.setUsuario(rs.getString(7));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int insertar(Empleado em) {
        String sql = "insert into empleado(nombre, apellido, ci, direccion, telefono, usuario, clave) values(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellido());
            ps.setInt(3, em.getCi());
            ps.setString(4, em.getDireccion());
            ps.setString(5, em.getTelefono());
            ps.setString(6, em.getUsuario());
            ps.setString(7, em.getClave());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Empleado listar_id(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where id_empleado ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setCi(rs.getInt(4));
                emp.setDireccion(rs.getString(5));
                emp.setTelefono(rs.getString(6));
                emp.setUsuario(rs.getString(7));
                emp.setClave(rs.getString(8));

            }

        } catch (Exception e) {
        }
        return emp;
    }

    public int editar(Empleado em) {
        String sql = "update empleado set nombre=?, apellido=?, ci=?, direccion=?, telefono=?, usuario=?, clave=? where id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellido());
            ps.setInt(3, em.getCi());
            ps.setString(4, em.getDireccion());
            ps.setString(5, em.getTelefono());
            ps.setString(6, em.getUsuario());
            ps.setString(7, em.getClave());
            ps.setInt(8, em.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void borrar(int id) {
        String sql = "delete from empleado where id_empleado = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
