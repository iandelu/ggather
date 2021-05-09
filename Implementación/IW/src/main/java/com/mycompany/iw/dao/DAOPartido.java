/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.dao;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jesus Bueno
 */
public class DAOPartido extends ConexionBD {
    private static DAOPartido instance = null;
    private Partido partido = new Partido();
    private String url, usuario, password;
    private Properties sqlProperties;
    
    public DAOPartido(){
    }
    
    public DAOPartido(String url, String usuario, String password, Properties sqlProperties){
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        this.sqlProperties = sqlProperties;
    }
    
    public static DAOPartido getInstance() throws ClassNotFoundException, IOException, SQLException{
        if(instance == null){
            instance = new DAOPartido();
        }
        return instance;
    }
    
public int crearPartido(Partido partido){
    
    int status = 0;
    
    try{
        Connection con = getConnection(url, usuario, password);
        PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("crearPartido"));
        ps.setLong(1, partido.getId());
        ps.setLong(2, partido.getCreador().getId());
        ps.setInt(3, partido.getNivelPartido());
        ps.setLong(4, partido.getFechaHora().getIdReserva());
        ps.setLong(5, partido.getPistaPartido().getId());
    }catch (Exception e){System.out.println(e);}

       return status;
    }
}