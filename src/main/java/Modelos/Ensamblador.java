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
public class Ensamblador {

    int IDEnsamblador;
    String nombreEnsamblador;
    String apellidoEnsamblador;
    String telefonoEnsamblador;

    public Ensamblador() {
    }

    public Ensamblador(int IDEnsamblador, String nombreEnsamblador, String apellidoEnsamblador, String telefonoEnsamblador) {
        this.IDEnsamblador = IDEnsamblador;
        this.nombreEnsamblador = nombreEnsamblador;
        this.apellidoEnsamblador = apellidoEnsamblador;
        this.telefonoEnsamblador = telefonoEnsamblador;
    }

    public int getIDEnsamblador() {
        return IDEnsamblador;
    }

    public void setIDEnsamblador(int IDEnsamblador) {
        this.IDEnsamblador = IDEnsamblador;
    }

    public String getNombreEnsamblador() {
        return nombreEnsamblador;
    }

    public void setNombreEnsamblador(String nombreEnsamblador) {
        this.nombreEnsamblador = nombreEnsamblador;
    }

    public String getApellidoEnsamblador() {
        return apellidoEnsamblador;
    }

    public void setApellidoEnsamblador(String apellidoEnsamblador) {
        this.apellidoEnsamblador = apellidoEnsamblador;
    }

    public String getTelefonoEnsamblador() {
        return telefonoEnsamblador;
    }

    public void setTelefonoEnsamblador(String telefonoEnsamblador) {
        this.telefonoEnsamblador = telefonoEnsamblador;
    }

    
    
}
