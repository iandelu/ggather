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

    @Override
    public void insertar(Reserva j) {
        final String INSERT = "INSERT INTO reservas(idReservas, horaInicio, horaFin, fecha, idPistas) VALUES (?,?,?,?,?)"; 
        final String UPDATE = "UPDATE reservas horaInicio = ? , horaFin = ?, fecha = ? WHERE idReserva = ?";
        final String DELETE = "DELETE FROM reservas WHERE idReservas = ?";
        final String GETALL = "SELECT idReservas, horaInicio, horaFin, fecha, idPistas FROM reservas";
        final String GETONE = "SELECT * FROM reservas WHERE idReservas = ?";
        
         private Connection conn;
        
        public MySQLJugadorDAO(Connection conn) {
        
            this.conn = conn;
        
        }    
    }

    @Override
    public void modificar(Reserva j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Reserva j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
