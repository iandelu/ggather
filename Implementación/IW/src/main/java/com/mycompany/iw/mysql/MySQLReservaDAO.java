/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        

import com.mycompany.iw.Reserva;
import com.mycompany.iw.daos.ReservaDAO;
import com.mycompany.iw.daos.DAOException;
import java.util.List;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author LuisAneri
 */

public class MySQLReservaDAO implements ReservaDAO{
    
   

    final String INSERT = "INSERT INTO reservas(idReservas, horaInicio, horaFin, fecha, idPistas) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE reservas horaInicio = ? , horaFin = ?, fecha = ?, idPistas = ? WHERE idReserva = ?";
    final String DELETE = "DELETE FROM reservas WHERE idReservas = ?";
    final String GETALL = "SELECT idReservas, horaInicio, horaFin, fecha, idPistas FROM reservas";
    final String GETONE = "SELECT * FROM reservas WHERE idReservas = ?";
        
    private Connection conn;
        
    public MySQLReservaDAO(Connection conn) {
        
        this.conn = conn;
        
    }    
    
    @Override
    public void insertar(Reserva reserva) throws DAOException {
       PreparedStatement stat = null;
       ResultSet rs;
        
        try{
            stat = conn.prepareStatement(INSERT);
            
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                reserva.setIdReserva(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            Time timeInicio = Time.valueOf(reserva.getHoraInicio());
            Time timeFin = Time.valueOf(reserva.getHoraFin());
   
            stat.setLong(1, reserva.getIdReserva());
            stat.setTime(2, timeInicio);
            stat.setTime(3, timeFin);
            stat.setDate(4, Date.valueOf(reserva.getFecha()));
            stat.setLong(5, reserva.getPista());
            
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
    public void modificar(Reserva reserva) throws DAOException {
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);

            Time timeInicio = Time.valueOf(reserva.getHoraInicio());
            Time timeFin = Time.valueOf(reserva.getHoraFin());

            stat.setTime(1, timeInicio);
            stat.setTime(2, timeFin);
            stat.setDate(3, Date.valueOf(reserva.getFecha()));
            stat.setLong(4, reserva.getPista());
            stat.setLong(5, reserva.getIdReserva());
           
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
    public void eliminar(Reserva reserva) throws DAOException {
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, reserva.getIdReserva());

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

    private Reserva convertir(ResultSet rs) throws SQLException{
        
        Long idPistas = rs.getLong("idPistas");
        LocalTime horaInicio = rs.getTime("horaInicio").toLocalTime();
        LocalTime horaFinal = rs.getTime("horaFinal").toLocalTime();
        LocalDate fecha = rs.getDate("fecha").toLocalDate();
        Long pista = rs.getLong("idPistas");
        
        Reserva reserva = new Reserva( horaInicio,  horaFinal,  fecha,  pista);
        reserva.setIdReserva(rs.getLong("idReservas"));
        
        return reserva;
        
    }

    @Override
    public List<Reserva> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Reserva> reservas = new ArrayList<>();
       
        try{
           
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
               
                reservas.add(convertir(rs));
               
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
       
        return reservas;
    }

    @Override
    public Reserva obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Reserva reserva;
        
        try{
            
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                
                reserva = convertir(rs);
                
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
        
         return reserva;
    }

    
    
    
}
