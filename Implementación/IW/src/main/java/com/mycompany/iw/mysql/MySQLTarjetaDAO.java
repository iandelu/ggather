/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        


import com.mycompany.iw.Tarjeta;
import com.mycompany.iw.Valoracion;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.TarjetaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author LuisAneri
 */

public class MySQLTarjetaDAO implements TarjetaDAO{

    final String INSERT = "INSERT INTO tarjetas(idTarjeta, tipoTarjeta, idJugador, idJugadorAmonestador, motivo, comentario) VALUES (?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE tarjetas tipoTarjeta = ?, idJugador = ?, idJugadorAmonestador = ?, motivo = ?, comentario = ? WHERE idTarjeta = ?";
    final String DELETE = "DELETE FROM tarjetas WHERE idTarjeta = ?";
    final String GETALL = "SELECT idTarjeta, tipoTarjeta, idJugador, idJugadorAmonestador, motivo, comentario FROM tarjetas";
    final String GETONE = "SELECT idTarjeta, tipoTarjeta, idJugador, idJugadorAmonestador, motivo, comentario FROM tarjetas WHERE idTarjeta = ?";
    
    
    
    private Connection conn;
    
    public MySQLTarjetaDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    
    
    @Override
    public void insertar(Tarjeta j) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                j.setIdTarjeta(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            
            stat.setLong(1, j.getIdTarjeta());
            stat.setString(2, j.getTipoTarjeta());
            stat.setLong(3, j.getJugadorSancionado());
            stat.setLong(4, j.getJugadorAmonestador());
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
    public void modificar(Tarjeta j) throws DAOException{

        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            
            stat.setString(1, j.getTipoTarjeta());
            stat.setLong(2, j.getJugadorSancionado());
            stat.setLong(3, j.getJugadorAmonestador());
            stat.setString(4, j.getComentario());
            stat.setLong(5, j.getIdTarjeta());
            
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
    public void eliminar(Tarjeta j) throws DAOException{

        
        PreparedStatement stat = null;
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, j.getIdTarjeta());

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

    private Tarjeta convertir(ResultSet rs) throws SQLException{
        
        
        String tipotarjeta = rs.getString("tipoTarjeta");
        Long jsancionado = rs.getLong("idJugador");
        Long jValorador = rs.getLong("idJugadorAmonestador");
        String comentario = rs.getString("comentario");
        String motivo = rs.getString("motivo");
        
        Tarjeta j = new Tarjeta( jsancionado, jValorador, tipotarjeta,  motivo,  comentario);
        j.setIdTarjeta(rs.getLong("idTarjeta"));
        
        return j;
        
    }
    
    @Override
    public List<Tarjeta> obtenerTodos() throws DAOException{

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Tarjeta> tarjetas = new ArrayList<>();

        try{

            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){

                tarjetas.add(convertir(rs));

            }

        }catch(SQLException ex){
             throw new DAOException("Error en SQL", ex);
        }finally{

            if(rs != null){

                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL, ex");
                }

            }
            if(stat != null){

                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL, ex");
                }

            }
        }

         return tarjetas;

    }

    @Override
    public Tarjeta obtener(Long id) throws DAOException{

                PreparedStatement stat = null;
        ResultSet rs = null;
        Tarjeta j;

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
             throw new DAOException("Error en SQL, ex");
        }finally{

            if(rs != null){

                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL, ex");
                }

            }
            if(stat != null){

                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL, ex");
                }

            }
        }

         return j;

     }
    
    
}
