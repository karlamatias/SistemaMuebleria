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
public class Muebles {

    int id;
    String fecha;
    String ensamblador;
    int Stock;
    String precio;
    String nombre;
   ;

    public Muebles() {
    }

    public Muebles(int id, String fecha, String ensamblador, int Stock, String precio, String nombre) {
        this.id = id;
        this.fecha = fecha;
        this.ensamblador = ensamblador;
        this.Stock = Stock;
        this.precio = precio;
        this.nombre = nombre;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEnsamblador() {
        return ensamblador;
    }

    public void setEnsamblador(String ensamblador) {
        this.ensamblador = ensamblador;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
