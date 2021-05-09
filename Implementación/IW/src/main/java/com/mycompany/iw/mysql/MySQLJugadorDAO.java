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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisAneri
 */

public class MySQLJugadorDAO implements JugadorDao{
    
    final String INSERT = "INSERT INTO jugadores( usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia) VALUES (?,?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE jugadores usuario = ? , nombre = ?, email = ?, apellidos = ?, fechaNacimiento = ?, contraseña = ?,telefono = ? WHERE idJugador = ?";
    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia FROM jugadores";
    final String GETONE = "SELECT * FROM jugadores WHERE idJugador = ?";
    final String GETREQUEST = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono FROM jugadores, amigos "
            + "WHERE idJugador = idAmigo2 and idAmigo1 = ?";
    
    
    
    private Connection conn;
    
    public MySQLJugadorDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Jugador j) throws DAOException {
        
        PreparedStatement stat = null;
        ResultSet rs;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            /*rs = stat.getGeneratedKeys();
            if(rs.next()){
                j.setId(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            
           
            stat.setLong(1, j.getId());*/
            stat.setString(1, j.getUsuario());
            stat.setString(2, j.getNombre());
            stat.setString(3, j.getEmail());
            stat.setString(4, j.getApellidos());
            stat.setDate(5, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(6, j.getContraseña());
            stat.setFloat(7, j.getValoracionMedia());
            stat.setLong(8, j.getTelefono());
            
            
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
            }if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
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
            stat.setLong(7, j.getTelefono());
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

    
    private Jugador convertir(ResultSet rs) throws SQLException{
        
        String usuario = rs.getString("usuario");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String contraseña = rs.getString("contraseña");
        String email = rs.getString("email");
        Date fechaNacimiento = rs.getDate("fechaNacimiento");
        float valoracionMedia = rs.getFloat("valoracionMedia");
        int telefono = rs.getInt("telefono");
        
        Jugador j = new Jugador(usuario, nombre, apellidos, email, telefono, contraseña, fechaNacimiento, valoracionMedia);
        j.setId(rs.getLong("idJugador"));
        
        return j;
        
    }
    
    @Override
    public List<Jugador> obtenerTodos() throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Jugador> jugadores = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               jugadores.add(convertir(rs));
               
           }
           
       }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
       }finally{
           
           if(rs != null){
               
               try{
                   rs.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
           if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
       }
       
        return jugadores;
    }


    @Override
    public Jugador obtener(Long id) throws DAOException{
        
       PreparedStatement stat = null;
       ResultSet rs = null;
       Jugador j;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               j = convertir(rs);
               
           }else{
               throw new DAOException("No se ha encontrado ese registro.");
           }
           
       }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
       }finally{
           
           if(rs != null){
               
               try{
                   rs.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
           if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
       }
       
        return j;
    }
    
    
    
    
    
    /* Funcion basica para obtener una lista con tus solicitudes*/
    public List<Jugador> obtenerSolicitudesAmistad(Long idJugador) throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Jugador> jugadores = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETREQUEST);
           stat.setLong(1, idJugador);
           rs = stat.executeQuery();
           while(rs.next()){
               
               jugadores.add(convertir(rs));
               
           }
           
       }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
       }finally{
           
           if(rs != null){
               
               try{
                   rs.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
           if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
       }
       
        return jugadores;
    }
    
    
}
