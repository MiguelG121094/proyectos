package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class conexion {

    public Connection cn = null;
    public Statement st = null;
    public ResultSet rs = null;
    public CallableStatement cs = null;

    public conexion() {

        inconectar();

    }

    private void inconectar() {
        try {
            conectar();
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar() throws Exception {
        String servidor = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = ""; // tu contraseÃ±a
        //String password = "admin"; // tu contraseÃ±a
        String driver = "com.mysql.cj.jdbc.Driver";
        String basedatos = "bd_taller_programacion"; //nombre de tu DB
        String cadenaconexion = "jdbc:mysql://" + servidor + ":" + puerto + "/" + basedatos;
        Class.forName(driver);
        cn = DriverManager.getConnection(cadenaconexion, usuario, password);
    }

    public Connection conectar_reporte() throws Exception {
        String servidor = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = ""; // tu contraseÃ±a
        //String password = "admin"; // tu contraseÃ±a
        String driver = "com.mysql.cj.jdbc.Driver";
        String basedatos = "bd_taller_programacion"; //nombre de tu DB
        String cadenaconexion = "jdbc:mysql://" + servidor + ":" + puerto + "/" + basedatos;
        Class.forName(driver);
        cn = DriverManager.getConnection(cadenaconexion, usuario, password);

        return cn;
    }

    public ResultSet Consulta(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void Actualizacion(String sql) throws Exception {
        st = cn.createStatement();
        st.executeUpdate(sql);

    }

    public void desconectar() throws Exception {
        cn.close();
    }

    //PERSONALIZADO CALLABLE
    public void insertarCliente(String sql, String nom1, String nom2, String ape1, String ape2, String cedula) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nom1);
            cs.setString(2, nom2);
            cs.setString(3, ape1);
            cs.setString(4, ape2);
            cs.setString(5, cedula);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());;
        }
    }

    public ResultSet buscarDatos(String sql, int id_persona) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_persona);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    //**
    public ResultSet cargaPersonas_2(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    //DESDE ACA PARA EL PROYECTO
    //Empleado
    public ResultSet validarUsuarioClave(String sql, String usuario, String contraseña) throws Exception {
        cs = cn.prepareCall(sql);
        cs.setString(1, usuario);
        cs.setString(2, contraseña);
        rs = cs.executeQuery();
        return rs;
    }

    public ResultSet cargaEmpleado(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarEmpleado(String sql, String nombre, String apellido, int cedula, String direccion, String telefono, String usuario, String clave) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setInt(3, cedula);
            cs.setString(4, direccion);
            cs.setString(5, telefono);
            cs.setString(6, usuario);
            cs.setString(7, clave);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarEmpleado(String sql, int id_empleado) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_empleado);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet cargaEmpleado_id(String sql, int id_empleado) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_empleado);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public void editarEmpleado(String sql, int id_empleado, String nombre, String apellido, int cedula,
            String direccion, String telefono, String usuario, String clave) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_empleado);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setInt(4, cedula);
            cs.setString(5, direccion);
            cs.setString(6, telefono);
            cs.setString(7, usuario);
            cs.setString(8, clave);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //Cliente
    public ResultSet cargaCliente(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarCliente(String sql, String nombre, String apellido, int cedula, String direccion, String telefono, String ruc) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setInt(3, cedula);
            cs.setString(4, direccion);
            cs.setString(5, telefono);
            cs.setString(6, ruc);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarCliente(String sql, int id_cliente) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_cliente);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet cargaCliente_id(String sql, int id_cliente) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_cliente);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public void editarCliente(String sql, int id_cliente, String nombre, String apellido, int cedula,
            String direccion, String telefono, String ruc) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_cliente);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setInt(4, cedula);
            cs.setString(5, direccion);
            cs.setString(6, telefono);
            cs.setString(7, ruc);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //proveedor
    public ResultSet cargaProveedor(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarProveedor(String sql, String nombre, String apellido, int cedula, String direccion, String telefono, String ruc) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setInt(3, cedula);
            cs.setString(4, direccion);
            cs.setString(5, telefono);
            cs.setString(6, ruc);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarProveedor(String sql, int id_proveedor) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_proveedor);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet cargaProveedor_id(String sql, int id_proveedor) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_proveedor);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public void editarProveedor(String sql, int id_proveedor, String nombre, String apellido, int cedula,
            String direccion, String telefono, String ruc) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_proveedor);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setInt(4, cedula);
            cs.setString(5, direccion);
            cs.setString(6, telefono);
            cs.setString(7, ruc);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //producto
    public ResultSet cargaProducto(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarProducto(String sql, String descripcion, int precio_compra, int precio_venta, int cantidad_minima) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, descripcion);
            cs.setInt(2, precio_compra);
            cs.setInt(3, precio_venta);
            cs.setInt(4, cantidad_minima);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarProducto(String sql, int id_producto) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_producto);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet cargaProducto_id(String sql, int id_producto) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_producto);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public void editarProducto(String sql, int id_producto, String descripcion, int precio_compra, int precio_venta,
            int cantidad_minima) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_producto);
            cs.setString(2, descripcion);
            cs.setInt(3, precio_compra);
            cs.setInt(4, precio_venta);
            cs.setInt(5, cantidad_minima);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    
    //Ventas
    public ResultSet cargaVenta(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet obtenerId_empleado_user(String sql, String usuario) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, usuario);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }
    
    public void insertarDatos_cabVenta(String sql, String fecha_venta, int id_cliente, int id_empleado) {
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, fecha_venta);
            cs.setInt(2, id_cliente);
            cs.setInt(3, id_empleado);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public ResultSet ultimoId_cab_venta(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    

}
