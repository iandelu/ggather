/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        

import com.mycompany.iw.Resultado;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.ResultadoDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author LuisAneri
 */

public class MySQLResultadoDAO implements ResultadoDAO{

    final String INSERT = "INSERT INTO resultados(idResultados, idJugadorPoniente, idPartido, resultados, mvp) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE resultados idJugadorPoniente = ?, idPartido = ?, resultados = ?, mvp = ? WHERE idResultados = ?";
    final String DELETE = "DELETE FROM resultados WHERE idResultados = ?";
    final String GETALL = "SELECT * FROM resultados";
    final String GETONE = "SELECT * WHERE idResultados = ?";
    
    
    private Connection conn;
    
    public MySQLValoracionDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    @Override
    public void insertar(Resultado r) {
        PreparedStatement stat = null;
        ResultSet rs;
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                r.setId(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            stat.setLong(1, r.getIdResultado());
            stat.setLong(2, r.getJugadorValorador());
            stat.setInt(3, r.getValoracion());
            stat.setLong(4, r.getJugadorValorado());
            stat.setString(5, r.getComentario());
            
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
    public void modificar(Resultado r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Resultado r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resultado> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
