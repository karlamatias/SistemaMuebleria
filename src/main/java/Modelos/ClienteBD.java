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
public class ClienteBD {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public Cliente buscar(String nit) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM CLIENTE WHERE NITCliente=" + nit;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setNit(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setDireccion(rs.getString(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    //mostrar en forma de lista los clientes de la base de datos.
    public List Listar() {

        String sql = "SELECT * FROM CLIENTE";
        List<Cliente> lista = new ArrayList();

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNit(rs.getString("NITCliente"));
                cliente.setNombre(rs.getString("NombreCliente"));
                cliente.setApellido(rs.getString("apellidoCliente"));
                cliente.setDireccion(rs.getString("direccionCliente"));
                lista.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PiezasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
