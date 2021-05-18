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
    private Long mvp;

    public Resultado(Long jugadorPoniente, Long partido, String resultado, Long mvp) {
        this.jugadorPoniente = jugadorPoniente;
        this.partido = partido;
        this.resultado = resultado;
        this.mvp = mvp;
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
    
    public Long getMVP() {
        return mvp;
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
    
    public void setMVP(Long mvp) {
        this.mvp = mvp;
    }

    @Override
    public String toString() {
        return "Resultado{" + "idResultado=" + idResultado + ", jugadorPoniente=" + jugadorPoniente + ", partido=" + partido + ", resultado=" + resultado + ", mvp=" + mvp + '}';
    }
    
    
    
    

    
    
    

}
