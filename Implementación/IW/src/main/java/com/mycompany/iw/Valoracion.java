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
public class Valoracion {
    
    private Long id = null;
    private Jugador jugadorValorado;
    private Jugador jugadorValorador;
    private int valoracion;
    private String comentario;

    public Valoracion(Jugador jugadorValorado, Jugador jugadorValorador, int valoracion, String comentario) {
        this.jugadorValorado = jugadorValorado;
        this.jugadorValorador = jugadorValorador;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    
//getter de la calse valoracin
    public Long getId() {
        return id;
    }

    public Jugador getJugadorValorado() {
        return jugadorValorado;
    }

    public Jugador getJugadorValorador() {
        return jugadorValorador;
    }

    public int getValoracion() {
        return valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    
//setter de la clase valoracion
    public void setId(Long id) {
        this.id = id;
    }

    public void setJugadorValorado(Jugador jugadorValorado) {
        this.jugadorValorado = jugadorValorado;
    }

    public void setJugadorValorador(Jugador jugadorValorador) {
        this.jugadorValorador = jugadorValorador;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
