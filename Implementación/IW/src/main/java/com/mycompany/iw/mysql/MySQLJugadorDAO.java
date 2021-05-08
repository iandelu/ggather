/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.JugadorDao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author LuisAneri
 */

public class MySQLJugadorDAO implements JugadorDao{
    
    final String INSERT = "INSERT INTO jugadores(idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono) VALUES (?,?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE jugadores usuario = ? , nombre = ?, email = ?, apellidos = ?, fechaNacimiento = ?, contraseña = ?,telefono = ? WHERE idJugador = ?";
    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña, telefono FROM jugadores";
    final String GETONE = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña, telefono FROM jugadores WHERE idJugaodr = ?";
    
    
    
    private Connection conn;
    
    public MySQLJugadorDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    

    @Override
    public void insertar(Jugador j) throws DAOException {
        
        PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, j.getApellidos());
            stat.setString(2, j.getContraseña());
            stat.setString(3, j.getEmail());
            stat.setDate(4, new Date(j.getFechaNacimiento().getTime()));
            stat.setLong(5, j.getId());
            stat.setString(6, j.getNombre());
            stat.setInt(7, j.getTelefono());
            stat.setString(8, j.getUsuario());
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    
                }
            
            }
        }
        
        
    }

    @Override
    public void modificar(Jugador j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Jugador j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jugador> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jugador obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
