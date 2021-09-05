/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author karlamatias
 */
public class Devolucion {
    int id;
    int noFactura;
    String nitcliente;
    String monto;
    String fecha;

    public Devolucion() {
    }

    public Devolucion(int id, int noFactura, String nitcliente, String monto, String fecha) {
        this.id = id;
        this.noFactura = noFactura;
        this.nitcliente = nitcliente;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public String getNitcliente() {
        return nitcliente;
    }

    public void setNitcliente(String nitcliente) {
        this.nitcliente = nitcliente;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
