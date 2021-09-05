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
            //rs.next();
            while (rs.next()) {

                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setArea(rs.getString("area"));

            }
        } catch (Exception e) {
        }
        return user;
    }

    public List Listar() {

        String sql = "SELECT * FROM USUARIO";
        List<Usuarios> lista = new ArrayList<>();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setArea(rs.getString("area"));
                usuario.setPassword(rs.getString("password"));

                lista.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Usuarios us) {
        String sql = "INSERT INTO USUARIO (usuario, area, password) VALUES (?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getArea());
            ps.setString(3, us.getPassword());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Actualizar(Usuarios usuario) {
        String sql = "UPDATE USUARIO set area=?, password=? WHERE usuario=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getArea());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(String usuario) {
        String sql = "DELETE FROM USUARIO WHERE usuario=" + usuario;

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuarios listarporID(String us) {
        Usuarios usuario = new Usuarios();
        String sql = "SELECT * FROM USUARIO WHERE usuario=" + us;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setArea(rs.getString(2));
                usuario.setPassword(rs.getString(3));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;

    }
    
}
