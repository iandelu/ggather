/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        

import com.mycompany.iw.Puntuacion;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.PuntuacionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author LuisAneri
 */

/*
public class MySQLPuntuacionDAO implements PuntuacionDAO{

    
    final String INSERT = "INSERT INTO puntuaciones(idPuntuacion, puntuacion, comentario, idPista, idJugador) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE puntuaciones puntuacion = ?, comentario = ?, idPista = ?, idJugador = ? WHERE idPuntuacion = ?";
    final String DELETE = "DELETE FROM puntuaciones WHERE idPuntuacion = ?";
    final String GETALL = "SELECT idPuntuacion, puntuacion, comentario, idPista, idJugador FROM puntuaciones";
    final String GETONE = "SELECT idPuntuacion, puntuacion, comentario, idPista, idJugador FROM puntuaciones WHERE idPuntuacion = ?";
    
    
    private Connection conn;
    
    public MySQLPuntuacionDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    @Override
    public void insertar(Puntuacion j) {

        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, j.getId());
            stat.setLong(2, j.getJugadorValorador());
            stat.setInt(3, j.getValoracion());
            stat.setLong(4, j.getJugadorValorado());
            stat.setString(5, j.getComentario());
            
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
    public void modificar(Puntuacion j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Puntuacion j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Puntuacion> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Puntuacion obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
*/