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
public class MySQLDaoManager throws {
    
    private Connection conn;
    
    private MySQLClubDAO ;
    private MySQLJugadorDAO ;
    private MySQLPartidoDAO ;
    private MySQLPistaDAO ;
    private MySQLPrecioDAO ;
    private MySQLPuntuacionDAO ;
    private MySQLReservaDAO ;
    private MySQLResultadoDAO ;
    private MySQLTarjetaDAO;
    private MySQLValoracionDAO;
    
    public MySQLDaoManager(String host, String username, String password , String database){
        
        String url = "jdbc:mysql://" + host + "/" + database;
        conn = DriverManager.getConnection(url , username, password);
        
    }    
 
    public MySQLClubDAO getClubDAO();
    
    public MySQLJugadorDAO getJugadorDAO();
    
    public MySQLPartidoDAO getPartidoDAO();
    
    public MySQLPistaDAO getPistaDAO();
    
    public MySQLPrecioDAO getPrecioDAO();
    
    public MySQLPuntucionDAO getPuntuacionDAO();
    
    public MySQLReservaDAO getReservaDAO();
    
    public MySQLResultadoDAO getResultadoDAO();
    
    public MySQLTarjetaDAO getTarjetaDAO();
    
    public MySQLValoracionDAO getValoracionDAO();
    
}
