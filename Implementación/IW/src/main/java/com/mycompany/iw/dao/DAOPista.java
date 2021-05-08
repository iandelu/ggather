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
            ps.setString(1, pista.getClub());
            ps.setString(2, pista.getDeporte());
            ps.setTime(3, pista.getHorarioInicio());
            ps.setTime(4, pista.getHorarioFin());
            ps.setFloat(6, pista.getPrecioHora());
            
            status = ps.executeUpdate();
            
        } catch (Exception e){System.out.println(e);}
        
        
        return status;
    }
    
    public int modificarPista(Pista pista){
        
        int status = 0;
        
        try {
            Connection con = getConnection(url,usuario,password);
            PreparedStatement ps = con.prepareStatement(sqlProperties.getProperty("modificarPista"));
            ps.setString(1, pista.getClub());
            ps.setString(2, pista.getDeporte());
            ps.setTime(3, pista.getHorarioInicio());
            ps.setTime(4, pista.getHorarioFin());
            ps.setFloat(6, pista.getPrecioHora());
            
            status = ps.executeUpdate();
            
        } catch (Exception e) {System.out.print(e);}
        return status;
    }
    
    
}
