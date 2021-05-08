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

public class Resultado {
    
    private Long idResultado = null;
    private Long jugadorPoniente;
    private Long partido;
    private String resultado;

    public Resultado(Long jugadorPoniente, Long partido, String resultado) {
        this.jugadorPoniente = jugadorPoniente;
        this.partido = partido;
        this.resultado = resultado;
    }

    
 //getter 
    public Long getIdResultado() {
        return idResultado;
    }

    public Long getJugadorPoniente() {
        return jugadorPoniente;
    }

    public Long getPartido() {
        return partido;
    }

    public String getResultado() {
        return resultado;
    }

    
    
//setter
    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    public void setJugadorPoniente(Long jugadorPoniente) {
        this.jugadorPoniente = jugadorPoniente;
    }

    public void setPartido(Long partido) {
        this.partido = partido;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
    
    

    
    
    

}
