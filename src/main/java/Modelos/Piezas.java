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
public class Piezas {
    int IDPieza;
    String tipoPieza;
    String CantidadExistenteP;
    String precio;

    public Piezas() {
    }

    public Piezas(int IDPieza, String tipoPieza, String CantidadExistenteP, String precio) {
        this.IDPieza = IDPieza;
        this.tipoPieza = tipoPieza;
        this.CantidadExistenteP = CantidadExistenteP;
        this.precio = precio;
    }

    public int getIDPieza() {
        return IDPieza;
    }

    public void setIDPieza(int IDPieza) {
        this.IDPieza = IDPieza;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public String getCantidadExistenteP() {
        return CantidadExistenteP;
    }

    public void setCantidadExistenteP(String CantidadExistenteP) {
        this.CantidadExistenteP = CantidadExistenteP;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    
 
    
    
}
