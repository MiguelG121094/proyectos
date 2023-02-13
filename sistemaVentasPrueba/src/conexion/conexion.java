/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import formularios.acceso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class conexion {
    
    //llamamos a la clase Conection y le asignamos el nombre conexion
    public Connection conexion = null;
    
    //llamamos a las clases que nos ayudaran a hacer los ABM en la BD
    public Statement statement;
    public ResultSet resulSet;
    
    

    public boolean conectar(){
        System.out.println("Se ejecutó el método conectar");
        try {
                Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al ejecutar el driver de PostgreSQL: " + ex);
        }
        
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sistemaVentas", 
                    "postgres", "adolfo94");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void traerDatos(){
        try {
                statement = conexion.createStatement();
                resulSet = statement.executeQuery("select * from cliente");
                
                while (resulSet.next()) {
                    System.out.println("Ruc: " + resulSet.getString("ruc"));
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public static void main(String[] args) {
        conexion con = new conexion();
        con.conectar();
            
        //con.traerDatos();
        
        new acceso().setVisible(true);
    }

}
