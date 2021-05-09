/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;


import com.mycompany.iw.Jugador;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.JugadorDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


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
    
    
    
    
    
    public static void main(String[] args) throws SQLException, DAOException, ClassNotFoundException{
        
        Connection conn = null;
        try{
            //
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            JugadorDao jugadordao = new MySQLJugadorDAO(conn);
            Jugador j = new Jugador( "luisaneri",  "luis",  "aneri",  "luisaneri@uco.es", 601160060, "holaputa",  new Date(2000,9,13), 3);
            
            man.getJugadorDAO().insertar(j);
            List<Jugador> jugadores = man.getJugadorDAO().obtenerTodos();
            
            
            for(Jugador a: jugadores){
                System.out.println(a.toString());
            }
            
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        
    }
    
}
