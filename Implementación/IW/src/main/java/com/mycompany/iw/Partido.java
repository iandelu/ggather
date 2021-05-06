/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class Partido {
    
    private int id;
    private String deporte;
    private LocalDateTime fechaHora;
    private Jugador creador;
    private Pista pistaPartido;
    private ArrayList<Jugador> jugadores;

    
    //Constructor vacio de la clase Partido
    public Partido() {
    }

    public Partido(int id, String deporte, LocalDateTime fechaHora, Jugador creador, Pista pistaPartido) {
        this.id = id;
        this.deporte = deporte;
        this.fechaHora = fechaHora;
        this.creador = creador;
        this.pistaPartido = pistaPartido;
    }

    public int getId() {
        return id;
    }

    public String getDeporte() {
        return deporte;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Jugador getCreador() {
        return creador;
    }

    public Pista getPistaPartido() {
        return pistaPartido;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setCreador(Jugador creador) {
        this.creador = creador;
    }

    public void setPistaPartido(Pista pistaPartido) {
        this.pistaPartido = pistaPartido;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    
    
}
