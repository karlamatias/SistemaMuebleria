/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author karlamatias
 */
public class Venta {

    int IdVenta, item, idMueble, cantidad;
    int numeroFactura;
    String descripcionProducto, fecha, idCliente, idUsuario;
    double precio, subtotal, monto;

    public Venta() {
    }

    public Venta(int IdVenta, int item, int idMueble, int cantidad, int numeroFactura, String descripcionProducto, String fecha, String idCliente, String idUsuario, double precio, double subtotal, double monto) {
        this.IdVenta = IdVenta;
        this.item = item;
        this.idMueble = idMueble;
        this.cantidad = cantidad;
        this.numeroFactura = numeroFactura;
        this.descripcionProducto = descripcionProducto;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(int idMueble) {
        this.idMueble = idMueble;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
