/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author LuisAneri
 */
public class MySQLDaoManager  {
    
    private Connection conn;
    
    private MySQLClubDAO clubs =  null;
    private MySQLJugadorDAO jugadores =  null;
    private MySQLPartidoDAO partidos=  null;
    private MySQLPistaDAO pistas =  null;
    private MySQLPrecioDAO precios =  null;
    private MySQLPuntuacionDAO puntuaciones =  null;
    private MySQLReservaDAO reservas =  null;
    private MySQLResultadoDAO resultados =  null;
    private MySQLTarjetaDAO tarjetas =  null;
    private MySQLValoracionDAO valoraciones =  null;
    
    public MySQLDaoManager(String host, String username, String password , String database) throws SQLException{
        
        String url = "jdbc:mysql://" + host + "/" + database;
        conn = DriverManager.getConnection(url , username, password);
        
    }    
 
    public MySQLClubDAO getClubDAO(){
        
        if(clubs == null){
            clubs = new MySQLClubDAO(conn);
        }
        return clubs;
    }
    
    public MySQLJugadorDAO getJugadorDAO(){
        
        if(jugadores == null){
            jugadores = new MySQLJugadorDAO(conn);
        }
        return jugadores;
    }
    
    public MySQLPartidoDAO getPartidoDAO(){
        
        if(partidos == null){
            partidos = new MySQLPartidoDAO(conn);
        }
        return partidos;
    }
    
    public MySQLPistaDAO getPistaDAO(){
        
        if(pistas == null){
            pistas = new MySQLPistaDAO(conn);
        }
        return pistas;
    }
    
    public MySQLPrecioDAO getPrecioDAO(){
        
        if(precios == null){
            precios = new MySQLPrecioDAO(conn);
        }
        return precios;
    }
    
    public MySQLPuntuacionDAO getPuntuacionDAO(){
        
        if(puntuaciones == null){
            puntuaciones = new MySQLPuntuacionDAO(conn);
        }
        return puntuaciones;
    }
    
    public MySQLReservaDAO getReservaDAO(){
        
        if(reservas == null){
            reservas = new MySQLReservaDAO(conn);
        }
        return reservas;
    }
    
    public MySQLResultadoDAO getResultadoDAO(){
        
        if(resultados == null){
            resultados = new MySQLResultadoDAO(conn);
        }
        return resultados;
    }
    
    public MySQLTarjetaDAO getTarjetaDAO(){
        
        if(tarjetas == null){
            tarjetas = new MySQLTarjetaDAO(conn);
        }
        return tarjetas;
    }
    
    public MySQLValoracionDAO getValoracionDAO(){
        
        if(valoraciones == null){
            valoraciones = new MySQLValoracionDAO(conn);
        }
        return valoraciones;
    }
    
}
