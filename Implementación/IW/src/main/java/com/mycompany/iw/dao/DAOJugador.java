package com.mycompany.iw.dao;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Properties;
import java.io.FileInputStream;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.dao.ConexionBD;


public class DAOJugador extends ConexionBD{
    
    private static DAOJugador instance = null;
    private Jugador jugador = new Jugador();
    private String url, usuario, password;
    private Properties sqlProperties;
    
    public DAOJugador(){

    }

    public DAOJugador(String url, String usuario, String password, Properties sqlProperties) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        this.sqlProperties = sqlProperties;
    }

    
    public static DAOJugador getInstance() throws ClassNotFoundException, IOException, SQLException {
        if(instance == null) {
            instance = new DAOJugador();
        }
        return instance;
    }

    public int insertarJugador(Jugador jugador){
        
        int status = 0;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("insertarJugador"));
            ps.setString(1, jugador.getApellidos());
            ps.setString(2, jugador.getContraseña());
            ps.setString(3, jugador.getEmail());
            ps.setDate(4, jugador.getFechaNacimiento());
            ps.setString(6, jugador.getNombre());
            ps.setInt(7, jugador.getTelefono());
            ps.setString(8, jugador.getUsuario());
            
            status = ps.executeUpdate();
            
        } catch (Exception e){System.out.println(e);}
        
        
        return status;
    }
    
    public int modificarJugador(Jugador jugador){
        
        int status = 0;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("modificarJugador"));
            ps.setString(1, jugador.getApellidos());
            ps.setString(2, jugador.getEmail());
            ps.setDate(3, jugador.getFechaNacimiento());
            ps.setString(4, jugador.getUsuario());
            ps.setInt(5, jugador.getTelefono());
            ps.setString(6, jugador.getUsuario());
            ps.setString(7, jugador.getUsuario());
            
            status = ps.executeUpdate();
            
        } catch(Exception e){ System.out.println(e);}
        
        
        return status;
    }
    
    
    public int borrarJugador(Jugador jugador){
        
        int status = 0;
        
        
        try {
           
            Connection con = getConnection(url, usuario, password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("borrarJugador"));
            ps.setString(1, jugador.getUsuario());
            
            status = ps.executeUpdate();
            
           
        } catch(Exception e) { System.out.println(e);}
    
        return status;
    }
    
    
    public Jugador buscarJugador(Jugador jugador){
        
        PreparedStatement stmt = null;
        Jugador resul = null;
        ResultSet rs = null;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            stmt = con.prepareStatement(sqlProperties.getProperty("buscarJugador"));
            stmt.setString(1, jugador.getUsuario());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                resul = new Jugador(rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getInt("telefono"), rs.getInt("nivel"), rs.getString("deporte"));             
            }
            
                   
        } catch(Exception e) {System.out.println(e);}
        
        
        return resul;
        
        
        
    }
    
    public Jugador loginJugador(Jugador jugador){
        
        PreparedStatement stmt = null;
        Jugador resul = null;
        ResultSet rs = null;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            stmt = con.prepareStatement(sqlProperties.getProperty("loginJugador"));
            stmt.setString(1, jugador.getEmail());
            stmt.setString(2, jugador.getUsuario());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                resul = new Jugador(rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getInt("telefono"), rs.getString("contraseña"), rs.getDate("fechaNacimiento"));             
            }
            
                   
        } catch(Exception e) {System.out.println(e);}
        
        
        return resul;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}