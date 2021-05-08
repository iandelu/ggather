package com.mycompany.iw.dao;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Properties;
import java.io.FileInputStream;

import com.mycompany.iw.Pista;
import com.mycompany.iw.dao.ConexionBD;
/**
 *
 * @author youne
 */
public class DAOPista extends ConexionBD{
   
    private static DAOPista instance = null;
    private Pista pista = new Pista();
    private String url, usuario, password;
    private Properties sqlProperties;
    
    public DAOPista() {
    }

    public DAOPista(String url, String usuario, String password, Properties sqlProperties) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        this.sqlProperties = sqlProperties;
    }
    
     public static DAOPista getInstance() throws ClassNotFoundException, IOException, SQLException {
        if(instance == null) {
            instance = new DAOPista();
        }
        return instance;
    }
    
    public int insertarPista(Pista pista){
        
        int status = 0;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("insertarPista"));
            
            Time timeInicio = Time.valueOf(pista.getHorarioInicio());
            Time timeFin = Time.valueOf(pista.getHorarioFin());
            
            ps.setTime(3, timeInicio);
            ps.setTime(4, timeFin);
            ps.setFloat(5, pista.getPrecioHora());
            //ps.setFloat(6,pista.getPuntuacionMedia());

            status = ps.executeUpdate();
            
        } catch (Exception e){System.out.println(e);}
        
        
        return status;
    }
    
    public int modificarPista(Pista pista){
        
        int status = 0;
        
        try {
            Connection con = getConnection(url,usuario,password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("modificarPista"));
            
            Time timeInicio = Time.valueOf(pista.getHorarioInicio());
            Time timeFin = Time.valueOf(pista.getHorarioFin());
            
            ps.setTime(1, timeInicio);
            ps.setTime(2, timeFin);
            ps.setFloat(3, pista.getPrecioHora());
            ps.setLong(4,pista.getId());
            //ps.setFloat(6,pista.getPuntuacionMedia());
            
            status = ps.executeUpdate();
            
        } catch (Exception e) {System.out.print(e);}
        return status;
    }
    
    public int borrarPista(Pista pista) {
        int status = 0;
        
        try  {
            
            Connection con = getConnection(url,usuario,password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("borrarPista"));
            
            ps.setLong(1,pista.getId());
            
            status = ps.executeUpdate();
            
        } catch (Exception e) {System.out.print(e);}
        
       return status;
    }
    
    public Pista buscarPista(Pista pista){
        
        PreparedStatement stmt = null;
        Pista resul = null;
        ResultSet rs = null;
        
        try {
            
            Connection con = getConnection(url, usuario, password);
            stmt = con.prepareStatement(sqlProperties.getProperty("buscarPista"));
            stmt.setLong(1, pista.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                resul = new Pista(rs.getTime("horarioInicio"), rs.getTime("horarioFin"), rs.getFloat("precioHora"),rs.getFloat("puntuacionMedia"));             
            }
            
                   
        } catch(Exception e) {System.out.println(e);}
        
        
        return resul;
        
        
        
    }
    
    
    
}
