/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

import java.util.Calendar;
import java.time.*;

/**
 *
 * @author LuisAneri
 */

    //Constructor simple
    public class Reserva {
 
    private Long idReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fecha;

    public Reserva(Long idReserva, LocalTime horaInicio, LocalTime horaFin, LocalDate fecha) {
        this.idReserva = idReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    //Constructor vacio
    public Reserva() {
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    //Horas Restantes
    
    //Es posble cancelarla?
    
    
    
}
