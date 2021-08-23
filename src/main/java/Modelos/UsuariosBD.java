/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author karlamatias
 */
public class UsuariosBD {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    public Usuarios Validar(String usuario, String password) {
        Usuarios user = new Usuarios();
        String consulta = "SELECT * FROM USUARIO WHERE usuario = ? AND password = ?";
        con = cn.Conectar();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            while (rs.next()){
                
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setArea(rs.getString("area"));
            
            }
        } catch (Exception e) {
        }
        return user;
    }
    
    
}
