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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karlamatias
 */
public class DevolucionBD {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    
    //mostrar en forma de lista las devoluciones de la base de datos.
    public List Listar() {

        String sql = "SELECT * FROM DEVOLUCION";
        List<Devolucion> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Devolucion dev = new Devolucion();
                dev.setId(rs.getInt("IdDev"));
                dev.setNoFactura(rs.getInt("noFactura"));
                dev.setMonto(rs.getString("montoDev"));
                dev.setFecha(rs.getString("fechaventa"));
                lista.add(dev);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public int Agregar(Devolucion d) {
        String sql = "INSERT INTO DEVOLUCION (noFactura, NITcliente, montoDev, fechaventa) VALUES (?,?,?,?)";

        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getNoFactura());
            ps.setString(2, d.getNitcliente());
            ps.setString(3,d.getMonto());
            ps.setString(4, d.getFecha());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
