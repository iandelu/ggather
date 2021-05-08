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
            stat.setLong(1, j.getId());
            stat.setString(2, j.getUsuario());
            stat.setString(3, j.getNombre());
            stat.setString(4, j.getEmail());
            stat.setString(5, j.getApellidos());
            stat.setDate(6, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(7, j.getContraseña());
            stat.setInt(8, j.getTelefono());
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    
    @Override
    public void modificar(Jugador j) throws DAOException{

         PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, j.getUsuario());
            stat.setString(2, j.getNombre());
            stat.setString(3, j.getEmail());
            stat.setString(4, j.getApellidos());
            stat.setDate(5, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(6, j.getContraseña());
            stat.setInt(7, j.getTelefono());
            stat.setLong(8, j.getId());
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        
    }


    @Override
    public void eliminar(Jugador j) throws DAOException{
        
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, j.getId());

            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    private Jugador convertir(ResultSet rs){
        
        String nombre 
        
    }
    
    @Override
    public List<Jugador> obtenerTodos() throws DAOException{

        

    }

    @Override
    public Jugador obtener(Long id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
