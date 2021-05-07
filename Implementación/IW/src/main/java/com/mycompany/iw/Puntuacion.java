/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

/**
 *
 * @author LuisAneri
 */

public class Puntuacion {
    
    private Long id = null;
    private int puntuacion;
    private String comentario;
    private Pista pista;

    public Puntuacion(int puntuacion, String comentario, Pista pista) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.pista = pista;
    }

    //getter puntuacion
    public Long getId() {
        return id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public Pista getPista() {
        return pista;
    }
    
    
    
    //setter puntacion

    public void setId(Long id) {
        this.id = id;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }
    
}
