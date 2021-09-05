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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karlamatias
 */
public class EnsambleMueblesBD {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    
    public int EnsamblarMueble(EnsambleMueble em) {
        String sql = "INSERT INTO ENSAMBLE_MUEBLE (codigoEM, tipomueble, usuarioEnsamblador, fechaEnsamble, Piezas, cantNecesaria) VALUES (?,?,?,?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getCodigoEM());
            ps.setString(2, em.getTipomueble());
            ps.setInt(3,em.getUsuarioEnsamblador());
            ps.setString(4, em.getFechaEnsamble());
            ps.setInt(4, em.getIdPiza());
            ps.setInt(5, em.getCantNecesaria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnsambleMueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    
    
}
