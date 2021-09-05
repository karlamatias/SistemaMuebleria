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
public class VentaBD {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public String GenerarSerie() {
        String numeroserie = "";
        String consulta = "SELECT MAX(numeroSerie) FROM VENTA";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);

            }
        } catch (SQLException e) {
            Logger.getLogger(VentaBD.class.getName()).log(Level.SEVERE, null, e);
        }

        return numeroserie;

    }

    public int ObtenerMaximoIdVentas() {
        int idVenta = 0;
        String consulta = "SELECT MAX(IdVenta) FROM VENTA";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVenta = rs.getInt(1);

            }
        } catch (SQLException e) {
            Logger.getLogger(VentaBD.class.getName()).log(Level.SEVERE, null, e);
        }

        return idVenta;
    }

    public void GuardarDetalleVenta(Venta venta) {
        String sentencia = "INSERT INTO DETALLE_VENTA(codigoVe, IdMueble, cantidad, PrecioVenta) VALUES(?,?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, venta.getIdVenta());
            ps.setInt(2, venta.getIdMueble());
            ps.setDouble(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(VentaBD.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void GenerarFactura(Venta v) {
        String sentencia = "INSERT INTO FACTURA(NoFactura, codigoVenta, nitcliente, PrecioVenta) VALUES(?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, v.getNumeroFactura());
            ps.setInt(2, v.getIdVenta());
            ps.setString(3, v.getIdCliente());
            ps.setDouble(4, v.getMonto());
            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(VentaBD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardarVenta(Venta ve) {
        String sentencia = "INSERT INTO VENTA(IdEmpleado, fechaVenta, montoVenta, numeroSerie, nitCliente) VALUES (?,?,?,?,?)";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, ve.getIdUsuario());
            ps.setString(2, ve.getFecha());
            ps.setDouble(3, ve.getMonto());
            ps.setInt(4, ve.getNumeroFactura());
            ps.setString(5, ve.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(VentaBD.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
