/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;

/**
 *
 * @author youne
 */
public class Precio {
    
    private Long id = null;
    private Long idClub;
    private Long idDeporte;
    private String mañanaTarde;
    private Float precioHora;

    public Precio(Long idClub, Long idDeporte, String mañanaTarde, Float precioHora) {
        this.idClub = idClub;
        this.idDeporte = idDeporte;
        this.mañanaTarde = mañanaTarde;
        this.precioHora = precioHora;
    }

    public Long getId() {
        return id;
    }

    public Long getIdClub() {
        return idClub;
    }

    public Long getIdDeporte() {
        return idDeporte;
    }

    public String getMañanaTarde() {
        return mañanaTarde;
    }

    public Float getPrecioHora() {
        return precioHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdClub(Long idClub) {
        this.idClub = idClub;
    }

    public void setIdDeporte(Long idDeporte) {
        this.idDeporte = idDeporte;
    }

    public void setMañanaTarde(String mañanaTarde) {
        this.mañanaTarde = mañanaTarde;
    }

    public void setPrecioHora(Float precioHora) {
        this.precioHora = precioHora;
    }

    @Override
    public String toString() {
        return "Precio{" + "id=" + id + ", idClub=" + idClub + ", idDeporte=" + idDeporte + ", ma\u00f1anaTarde=" + mañanaTarde + ", precioHora=" + precioHora + '}';
    }
    
    
    
    
    
}
