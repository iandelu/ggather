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
public class Tarjeta {
    
    private Long idTarjeta = null;
    private Jugador jugadorSancionado;
    private Jugador jugadorAmonestador;
    private String tipoTarjeta;
    private String motivo;
    private String comentario;

    //Constructor principal
    public Tarjeta(Jugador jugadorSancionado, Jugador jugadorAmonestador, String tipoTarjeta, String motivo, String comentario) {
        this.jugadorSancionado = jugadorSancionado;
        this.jugadorAmonestador = jugadorAmonestador;
        this.tipoTarjeta = tipoTarjeta;
        this.motivo = motivo;
        this.comentario = comentario;
    }

    //Constructor vacio
    public Tarjeta() {
    }

    
    //Getter de la clase tarjeta
    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public Jugador getJugadorSancionado() {
        return jugadorSancionado;
    }

    public Jugador getJugadorAmonestador() {
        return jugadorAmonestador;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getComentario() {
        return comentario;
    }
    
    
    //Setter de la clase tarjeta

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setJugadorSancionado(Jugador jugadorSancionado) {
        this.jugadorSancionado = jugadorSancionado;
    }

    public void setJugadorAmonestador(Jugador jugadorAmonestador) {
        this.jugadorAmonestador = jugadorAmonestador;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
    
    
}
