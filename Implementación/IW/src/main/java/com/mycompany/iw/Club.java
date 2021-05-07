/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

/**
 *
 * @author crist
 */
public class Club {
    
    private String nombreClub;
    private String localizacion;
    private String email;
    private String contraseña;
    private long telefono;
    private String nombrePropietario;
    private boolean alta;

    public Club() {
    }

    public Club(String nombreClub, String localizacion, String email, String contraseña, long telefono, String nombrePropietario, boolean alta) {
        this.nombreClub = nombreClub;
        this.localizacion = localizacion;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.nombrePropietario = nombrePropietario;
        this.alta = alta;
    }

    //getters de la clase
    public String getNombreClub() {
        return nombreClub;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public bool getAlta() {
        return alta;
    }


    //seters de la clase
    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    
}
