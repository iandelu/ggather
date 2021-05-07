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
    
    private Long id = null;
    private String deporte;
    private Reserva reserva;
    private Jugador creador;
    private Pista pistaPartido;
    private ArrayList<Jugador> jugadores;
    private int numeroJugadores;
    private int nivelPartido;
    

    
    //Constructor vacio de la clase Partido
    public Partido() {
    }

    public Partido(Long id, String deporte, Reserva reserva, Jugador creador, Pista pistaPartido) {
        this.id = id;
        this.deporte = deporte;
        this.reserva = reserva;
        this.creador = creador;
        this.pistaPartido = pistaPartido;
    }

    public Long getId() {
        return id;
    }

    public String getDeporte() {
        return deporte;
    }
    
    public int getNivelPartido() {
        return nivelPartido;
    }

    public Reserva getFechaHora() {
        return reserva;
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
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setFechaHora(Reserva reserva) {
        this.reserva = reserva;
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
    
    
    //Permite a un jugador (clase jugador) inscribirse en el partido
    public boolean inscribirsePartido(Jugador jugador){
        
        if(jugadores.size() <= numeroJugadores){
            
            jugadores.add(jugador);
            return true;
        }
        
        calcularNivelPartido();
        return false;
        
    }
    
    public boolean inscribirColega(String nombre, String apellidos, int nivel){
        
        Jugador colega = new Jugador("COLEGA", nombre, apellidos, "COLEGA@COLEGA", 999999999, nivel, this.deporte);
        
        if(jugadores.size() <= numeroJugadores){
            
            jugadores.add(colega);
            return true;
        }
        
        calcularNivelPartido();
        return false;
        
    }
    
    public void calcularNivelPartido(){
        
        int media = 0;
        
        for(int i = 0; i< jugadores.size();i++){
            media = jugadores.get(i).getNivelJugador(deporte);
        }
        
        media = media/judarores.size();
        
        this.nivelPartido = media;
    }
}
