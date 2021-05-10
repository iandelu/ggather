/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

import java.time.LocalTime;

/**
 *
 * @author crist
 */
public class Pista {
    
    private Long id;
    private Long deporte;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private float precioHora;
    private float puntuacionMedia;
    private Long Club;
    
    public Pista() {
    }

    public Pista( Long deporte, LocalTime horarioInicio, LocalTime horarioFin, float puntuacionMedia, Long propietario) {
        this.deporte = deporte;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        //this.precioHora = precioHora;
        this.puntuacionMedia = puntuacionMedia;
        this.Club = propietario;
    }

    public Long getId() {
        return id;
    }

    public Long getDeporte() {
        return deporte;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public float getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public Long getClub() {
        return Club;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeporte(Long deporte) {
        this.deporte = deporte;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFin(LocalTime horarioFin) {
        this.horarioFin = horarioFin;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public void setPuntuacionMedia(float puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }

    public void setClub(Long propietario) {
        this.Club = propietario;
    }

    @Override
    public String toString() {
        return "Pista{" + "id=" + id + ", deporte=" + deporte + ", horarioInicio=" + horarioInicio + ", horarioFin=" + horarioFin + ", precioHora=" + precioHora + ", puntuacionMedia=" + puntuacionMedia + ", Club=" + Club + '}';
    }

    
    
    
    
}
