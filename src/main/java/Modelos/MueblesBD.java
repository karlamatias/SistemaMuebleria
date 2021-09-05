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
public class MueblesBD {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    //mostrar en forma de lista las piezas de la base de datos.
    public List Listar() {

        String sql = "SELECT * FROM MUEBLE";
        List<Muebles> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Muebles mueble = new Muebles();
                mueble.setId(rs.getInt("IDMueble"));
                mueble.setFecha(rs.getString("fechaEnsamble"));
                mueble.setPrecio(rs.getString("precio"));
                mueble.setEnsamblador(rs.getString("usuarioEnsamblador"));
                mueble.setStock(rs.getInt("CantidadExistente"));
                mueble.setNombre(rs.getString("nombreMueble"));
                lista.add(mueble);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Muebles m) {
        String sql = "INSERT INTO MUEBLE (fechaEnsamble, precio, usuarioEnsamblador, CantidadExistente, nombreMueble) VALUES (?,?,?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getFecha());
            ps.setString(2, m.getPrecio());
            ps.setString(3, m.getEnsamblador());
            ps.setInt(4, m.getStock());
            ps.setString(5, m.getNombre());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Muebles listarporID(int id) {
        Muebles mueble = new Muebles();
        String sql = "SELECT * FROM MUEBLE WHERE IDMueble=" + id;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                mueble.setFecha(rs.getString(2));
                mueble.setPrecio(rs.getString(3));
                mueble.setEnsamblador(rs.getString(4));
                mueble.setStock(rs.getInt(5));
                mueble.setNombre(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mueble;

    }

    public Muebles buscar(int id) {
        Muebles m = new Muebles();
        String sql = "SELECT * FROM MUEBLE WHERE IDMueble=" + id;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt(1));
                m.setFecha(rs.getString(2));
                m.setPrecio(rs.getString(3));
                m.setEnsamblador(rs.getString(4));
                m.setStock(rs.getInt(5));
                m.setNombre(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public int ActualizarStock(int id, int stock) {
        String sql = "UPDATE MUEBLE set CantidadExistente=? WHERE IDMueble=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

    }

    public int Actualizar(Muebles mueble) {
        String sql = "UPDATE MUEBLE set fechaEnsamble=?, precio=?, usuarioEnsamblador=?, CantidadExistente=?, nombreMueble=? WHERE IDMueble=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, mueble.getFecha());
            ps.setString(2, mueble.getPrecio());
            ps.setString(3, mueble.getEnsamblador());
            ps.setInt(4, mueble.getStock());
            ps.setString(5, mueble.getNombre());
            ps.setInt(6, mueble.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "DELETE FROM MUEBLE WHERE IDMueble=" + id;

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List ListarASC() {

        String sql = "SELECT * FROM MUEBLE ORDER BY CantidadExistente ASC";
        List<Muebles> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Muebles mueble = new Muebles();
                mueble.setId(rs.getInt("IDMueble"));
                mueble.setFecha(rs.getString("fechaEnsamble"));
                mueble.setPrecio(rs.getString("precio"));
                mueble.setEnsamblador(rs.getString("usuarioEnsamblador"));
                mueble.setStock(rs.getInt("CantidadExistente"));
                mueble.setNombre(rs.getString("nombreMueble"));
                lista.add(mueble);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public List ListarDESC() {

        String sql = "SELECT * FROM MUEBLE ORDER BY CantidadExistente DESC";
        List<Muebles> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Muebles mueble = new Muebles();
                mueble.setId(rs.getInt("IDMueble"));
                mueble.setFecha(rs.getString("fechaEnsamble"));
                mueble.setPrecio(rs.getString("precio"));
                mueble.setEnsamblador(rs.getString("usuarioEnsamblador"));
                mueble.setStock(rs.getInt("CantidadExistente"));
                mueble.setNombre(rs.getString("nombreMueble"));
                lista.add(mueble);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MueblesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    

}
