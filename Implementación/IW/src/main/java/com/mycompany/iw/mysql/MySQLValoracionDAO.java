/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;

import com.mycompany.iw.Club;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.Valoracion;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.ValoracionDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisAneri
 */

public class MySQLValoracionDAO implements ValoracionDAO {

    
    final String INSERT = "INSERT INTO valoraciones_jugadores(usuarioValorador, puntuacion, idJugadorValorado, comentario) VALUES (?,?,?,?)"; 
    final String UPDATE = "UPDATE valoraciones_jugadores SET usuarioValorador = ?, puntuacion = ?, idJugadorValorado = ?, comentario = ? WHERE idValoracionesJugadores = ?";
    final String DELETE = "DELETE FROM valoraciones_jugadores WHERE idValoracionesJugadores = ?";
    final String GETALL = "SELECT idValoracionesJugadores, usuarioValorador, puntuacion, idJugadorValorado, comentario FROM valoraciones_jugadores";
    final String GETONE = "SELECT idValoracionesJugadores, usuarioValorador, puntuacion, idJugadorValorado, comentario FROM valoraciones_jugadores WHERE idValoracionesJugadores = ?";
    
    
    private Connection conn;
    
    public MySQLValoracionDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    
    @Override
    public void insertar(Valoracion j) throws DAOException {

        PreparedStatement stat = null;
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            
            
            stat.setLong(1, j.getJugadorValorador());
            stat.setInt(2, j.getValoracion());
            stat.setLong(3, j.getJugadorValorado());
            stat.setString(4, j.getComentario());
            
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
    public void modificar(Valoracion j) throws DAOException {

        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            
            stat.setLong(1, j.getJugadorValorador());
            stat.setInt(2, j.getValoracion());
            stat.setLong(3, j.getJugadorValorado());
            stat.setString(4, j.getComentario());
            stat.setLong(5, j.getId());
            
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
    public void eliminar(Valoracion j) throws DAOException{

        
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

    private Valoracion convertir(ResultSet rs) throws SQLException{
        
        
        Long jValorado = rs.getLong("idJugadorValorado");
        Long jValorador = rs.getLong("usuarioValorador");
        int puntuacion = rs.getInt("puntuacion");
        String comentario = rs.getString("comentario");
        
        Valoracion j = new Valoracion( jValorado,  jValorador,  puntuacion,  comentario);
        j.setId(rs.getLong("idValoracionesJugadores"));
        
        return j;
        
    }
    
    @Override
    public List<Valoracion> obtenerTodos() throws DAOException{

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Valoracion> valoraciones = new ArrayList<>();

        try{

            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){

                valoraciones.add(convertir(rs));

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

         return valoraciones;
    

    }

    @Override
    public Valoracion obtener(Long id) throws DAOException{

        PreparedStatement stat = null;
        ResultSet rs = null;
        Valoracion j;

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

    
    String GETVALORACIONES = "SELECT idValoracionesJugadores, usuarioValorador, puntuacion, idJugadorValorado, comentario FROM valoraciones_jugadores WHERE idJugadorValorado = ?";
    
    public List<Valoracion> getValoracionesJugador(Long id) throws DAOException{

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Valoracion> valoraciones = new ArrayList<>();

        try{
     

            stat = conn.prepareStatement(GETVALORACIONES);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            while(rs.next()){

                valoraciones.add(convertir(rs));

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

         return valoraciones;
    
    }
    /**
     * calcular la nueva valoracion media para su posterior UPDATE
     * @param v
     * @return valoracio media
     */
    public float calcularValoracion(List<Valoracion> v){
        
        float valoracionMedia = 0;
        
        for (Valoracion valoracion : v)
        {
            valoracionMedia = valoracionMedia + valoracion.getValoracion();
        }
        
        valoracionMedia = valoracionMedia /v.size();
        
        return valoracionMedia;
    }
    

    public Jugador buscarJugadorPorEmail(String email) throws DAOException{
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        Jugador j;
        try{
            
            stat = conn.prepareStatement(BUSCARPOREMAIL);
            stat.setString(1, email);
            rs = stat.executeQuery();
            if(rs.next()){
                
                j = convertir(rs);
            }else{
            	
                j = null;
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

}

