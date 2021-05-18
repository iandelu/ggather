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
    private Long jugadorValorado;
    private Long jugadorValorador;
    private int valoracion;
    private String comentario;

    public Valoracion(Long jugadorValorado, Long jugadorValorador, int valoracion, String comentario) {
        this.jugadorValorado = jugadorValorado;
        this.jugadorValorador = jugadorValorador;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    
//getter de la calse valoracin
    public Long getId() {
        return id;
    }

    public Long getJugadorValorado() {
        return jugadorValorado;
    }

    public Long getJugadorValorador() {
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

    public void setJugadorValorado(Long jugadorValorado) {
        this.jugadorValorado = jugadorValorado;
    }

    public void setJugadorValorador(Long jugadorValorador) {
        this.jugadorValorador = jugadorValorador;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Valoracion{" + "id=" + id + ", jugadorValorado=" + jugadorValorado + ", jugadorValorador=" + jugadorValorador + ", valoracion=" + valoracion + ", comentario=" + comentario + '}';
    }
    
    
}
