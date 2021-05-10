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
    private Long jugadorSancionado;
    private Long jugadorAmonestador;
    private String tipoTarjeta;
    private String motivo;
    private String comentario;

    //Constructor principal
    public Tarjeta(Long jugadorSancionado, Long jugadorAmonestador, String tipoTarjeta, String motivo, String comentario) {
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

    public Long getJugadorSancionado() {
        return jugadorSancionado;
    }

    public Long getJugadorAmonestador() {
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

    public void setJugadorSancionado(Long jugadorSancionado) {
        this.jugadorSancionado = jugadorSancionado;
    }

    public void setJugadorAmonestador(Long jugadorAmonestador) {
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

    @Override
    public String toString() {
        return "Tarjeta{" + "idTarjeta=" + idTarjeta + ", jugadorSancionado=" + jugadorSancionado + ", jugadorAmonestador=" + jugadorAmonestador + ", tipoTarjeta=" + tipoTarjeta + ", motivo=" + motivo + ", comentario=" + comentario + '}';
    }
    
    
    
    
    
}
