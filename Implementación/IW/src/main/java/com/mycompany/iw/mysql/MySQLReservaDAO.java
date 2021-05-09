/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        

import com.mycompany.iw.Reserva;
import com.mycompany.iw.daos.ReservaDAO;
import java.util.List;



/**
 *
 * @author LuisAneri
 */

public class MySQLReservaDAO implements ReservaDAO{
    
   

    final String INSERT = "INSERT INTO reservas(idReservas, horaInicio, horaFin, fecha, idPistas) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE reservas horaInicio = ? , horaFin = ?, fecha = ? WHERE idReserva = ?";
    final String DELETE = "DELETE FROM reservas WHERE idReservas = ?";
    final String GETALL = "SELECT idReservas, horaInicio, horaFin, fecha, idPistas FROM reservas";
    final String GETONE = "SELECT * FROM reservas WHERE idReservas = ?";
        
    private Connection conn;
        
    public MySQLJugadorDAO(Connection conn) {
        
        this.conn = conn;
        
    }    
    
    @Override
    public void insertar(Reserva reserva) throws DAOException {
       PreparedStatement stat = null;
       
        
        try{
            stat = conn.prepareStatement(INSERT);
            
            Time timeInicio = Time.valueOf(reserva.getHoraInicio());
            Time timeFin = Time.valueOf(reserva.getHoraFin());
   
            stat.setLong(1, reserva.getId());
            stat.setTime(2, timeInicio);
            stat.setTime(3, timeFin);
            stat.setDate(6, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(5, j.getIdPistas());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Reserva reserva) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva obtener(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
