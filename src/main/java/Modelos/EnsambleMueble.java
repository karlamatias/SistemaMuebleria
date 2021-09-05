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
public class EnsambleMueble {

    int codigoEM;
    String tipomueble;
    int usuarioEnsamblador;
    String fechaEnsamble;
    int cantNecesaria;
    String descripcionPieza;
    int idPiza;
    double precio, subtotal, monto;
    int item;

    public EnsambleMueble() {
    }

    public EnsambleMueble(int codigoEM, String tipomueble, int usuarioEnsamblador, String fechaEnsamble, int cantNecesaria, String descripcionPieza, int idPiza, double precio, double subtotal, double monto, int item) {
        this.codigoEM = codigoEM;
        this.tipomueble = tipomueble;
        this.usuarioEnsamblador = usuarioEnsamblador;
        this.fechaEnsamble = fechaEnsamble;
        this.cantNecesaria = cantNecesaria;
        this.descripcionPieza = descripcionPieza;
        this.idPiza = idPiza;
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
        this.item = item;
    }

    public int getCodigoEM() {
        return codigoEM;
    }

    public void setCodigoEM(int codigoEM) {
        this.codigoEM = codigoEM;
    }

    public String getTipomueble() {
        return tipomueble;
    }

    public void setTipomueble(String tipomueble) {
        this.tipomueble = tipomueble;
    }

    public int getUsuarioEnsamblador() {
        return usuarioEnsamblador;
    }

    public void setUsuarioEnsamblador(int usuarioEnsamblador) {
        this.usuarioEnsamblador = usuarioEnsamblador;
    }

    public String getFechaEnsamble() {
        return fechaEnsamble;
    }

    public void setFechaEnsamble(String fechaEnsamble) {
        this.fechaEnsamble = fechaEnsamble;
    }

    public int getCantNecesaria() {
        return cantNecesaria;
    }

    public void setCantNecesaria(int cantNecesaria) {
        this.cantNecesaria = cantNecesaria;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getIdPiza() {
        return idPiza;
    }

    public void setIdPiza(int idPiza) {
        this.idPiza = idPiza;
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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

   
   
}
