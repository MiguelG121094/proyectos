/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.gbl;
import com.mysql.cj.xdevapi.Result;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Miguel
 */
public class loginDAO {
    String usuario;
    String clave;
    ResultSet rs;
    Connection cn;
    public CallableStatement cs;
    
    public loginDAO() {
    }

    public loginDAO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public ResultSet logueo() throws Exception{
        try {
            cn = gbl.cx.conectar_reporte();
            String usuario2 = this.getUsuario();
            String clave2 = this.getClave();
            cs = cn.prepareCall("CALL `sp_login`(?,?)");
            cs.setString(1, usuario2);
            cs.setString(2, clave2);
            rs = cs.executeQuery();
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return rs;
        
    }
    
    
}
