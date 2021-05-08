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
    private String estado;
    
    private int numeroJugadores;
    private int nivelPartido;
    
    
    private ArrayList<Jugador> jugadores;
    private ArrayList<Resultado> resultados;

    
    
    //Constructor 
    public Partido(String deporte, Reserva reserva, Jugador creador, Pista pistaPartido, String estado, int numeroJugadores, int nivelPartido, ArrayList<Jugador> jugadores, ArrayList<Resultado> resultados) {
        this.deporte = deporte;
        this.reserva = reserva;
        this.creador = creador;
        this.pistaPartido = pistaPartido;
        this.estado = estado;
        this.numeroJugadores = numeroJugadores;
        this.nivelPartido = nivelPartido;
        this.jugadores = jugadores;
        this.resultados = resultados;
    }
    
    //Constructor vacio de la clase Partido
    public Partido() {
    }
    
    
    
    //Getters de la clase
    public Long getId(){
        return id;
    }

    public String getDeporte() {    
        return deporte;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Jugador getCreador() {
        return creador;
    }

    public Pista getPistaPartido() {
        return pistaPartido;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public int getNivelPartido() {
        return nivelPartido;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    
    public ArrayList<Resultado> getResultados() {
        return resultados;
    }
    
    
    
    
    //setter de la clase

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setCreador(Jugador creador) {
        this.creador = creador;
    }

    public void setPistaPartido(Pista pistaPartido) {
        this.pistaPartido = pistaPartido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public void setNivelPartido(int nivelPartido) {
        this.nivelPartido = nivelPartido;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setResultados(ArrayList<Resultado> resultados) {
        this.resultados = resultados;
    }
    
    

//Permite a un jugador (clase jugador) inscribirse en el partido
//Una vez que el jugador añade un colega se actualiza el nivel medio del partido 
    
    public boolean inscribirsePartido(Jugador jugador) {
        if(jugadores.size() <= numeroJugadores){
            
            jugadores.add(jugador);
            return true;
        }
        
        calcularNivelPartido();
        return false;
    }
    
//Permite añadir a un colega pasando unicamente nombre, apellidos y un nivel
//En la base de datos aquellos jugadores que sean colegas se guardaran con nombre de usurio "COLEGA"
//Una vez que el jugador añade un colega se actualiza el nivel medio del partido 
    
    public boolean inscribirColega(String nombre, String apellidos, int nivel){
        
        Jugador colega = new Jugador("COLEGA", nombre, apellidos, "COLEGA@COLEGA", 999999999, nivel, this.deporte);
        
        if(jugadores.size() <= numeroJugadores){
            
            jugadores.add(colega);
            return true;
        }
        
        calcularNivelPartido();
        return false;
        
    }

//Recorre los jugadores y calcula la media del nivel de cada jugador
    public void calcularNivelPartido(){
        
        int media = 0;
        
        for(int i = 0; i< jugadores.size();i++){
            media = jugadores.get(i).getNivelJugador(deporte);
        }
        
        media = media/judarores.size();
        
        this.nivelPartido = media;
    }
    
//Añade un resultado por jugador
    
    public boolean añadirResultado(Resultado resultado, Jugador jugador){
        
        for(int i = 0; i < resultados.size();i++){
            
            if(resultados.get(i).getJugadorPoniente() == jugador){
                return false;
            }
        }
        
        if(resultados.size() >= jugadores.size()){
            return false;
        }
        
        resultados.add(resultado);
        return true;
    }
    
    public String getResultadoFinal(){
        
        String resultadoPrimero = resultados.get(0).getResultado();
        
        for(int i = 0; i < resultados.size(); i++){
            
            if(resultadoPrimero != resultados.get(i).getResultado()){
                return "Resultados_no_coinciden";
            }
        }
        
        return resultadoPrimero;
    }
}
