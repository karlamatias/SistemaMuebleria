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
public class PiezasBD {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    //mostrar en forma de lista las piezas de la base de datos.
    public List Listar() {

        String sql = "SELECT * FROM PIEZAS";
        List<Piezas> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Piezas pieza = new Piezas();
                pieza.setIDPieza(rs.getInt("IDPieza"));
                pieza.setTipoPieza(rs.getString("tipoPieza"));
                pieza.setCantidadExistenteP(rs.getString("CantidadExistenteP"));
                pieza.setPrecio(rs.getString("precio"));
                lista.add(pieza);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public int Agregar(Piezas p) {
        String sql = "INSERT INTO PIEZAS (tipoPieza,CantidadExistenteP,precio) VALUES (?,?,?)";

        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTipoPieza());
            ps.setString(2, p.getCantidadExistenteP());
            ps.setString(3, p.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Piezas listarporID(int id) {
        Piezas pieza = new Piezas();
        String sql = "SELECT * FROM PIEZAS WHERE IDPieza=" + id;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pieza.setTipoPieza(rs.getString(2));
                pieza.setCantidadExistenteP(rs.getString(3));
                pieza.setPrecio(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pieza;

    }

    public int Actualizar(Piezas p) {
        String sql = "UPDATE PIEZAS set tipoPieza=? ,CantidadExistenteP=?,precio=? WHERE IDPieza=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTipoPieza());
            ps.setString(2, p.getCantidadExistenteP());
            ps.setString(3, p.getPrecio());
            ps.setInt(4, p.getIDPieza());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "DELETE FROM PIEZAS WHERE IDPieza=" + id;

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List ListarASC() {

        String sql = "SELECT * FROM PIEZAS ORDER BY CantidadExistenteP ASC";
        List<Piezas> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Piezas pieza = new Piezas();
                pieza.setIDPieza(rs.getInt("IDPieza"));
                pieza.setTipoPieza(rs.getString("tipoPieza"));
                pieza.setCantidadExistenteP(rs.getString("CantidadExistenteP"));
                pieza.setPrecio(rs.getString("precio"));
                lista.add(pieza);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public List ListarDESC() {

        String sql = "SELECT * FROM PIEZAS ORDER BY CantidadExistenteP DESC";
        List<Piezas> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Piezas pieza = new Piezas();
                pieza.setIDPieza(rs.getInt("IDPieza"));
                pieza.setTipoPieza(rs.getString("tipoPieza"));
                pieza.setCantidadExistenteP(rs.getString("CantidadExistenteP"));
                pieza.setPrecio(rs.getString("precio"));
                lista.add(pieza);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public int LeerCSV(Piezas p)
    {
        String sql= "LOAD DATA LOCAL INFILE 'ruta' into table PIEZAS FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n'";
       
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ps.setString(1, p.getTipoPieza());
            ps.setString(2, p.getCantidadExistenteP());
            ps.setString(3, p.getPrecio());
            ps.executeUpdate();
 
        }
         catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
  
  public int ActualizarStock(int id, int stock) {
        String sql = "UPDATE PIEZAS set CantidadExistenteP=? WHERE IDPieza=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

    }
    
}
