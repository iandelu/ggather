/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

import java.util.logging.Logger;

/**
 *
 * @author LuisAneri
 */

public class Puntuacion {
    
    private Long id = null;
    private int puntuacion;
    private String comentario;
    private Long pista;
    private Long idJugador;

    public Puntuacion(int puntuacion, String comentario, Long pista, Long idJugador) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.pista = pista;
        this.idJugador = idJugador;
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

    public Long getPista() {
        return pista;
    }

    public Long getIdJugador() {
        return idJugador;
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

    public void setPista(Long pista) {
        this.pista = pista;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }
    
    
    
}
