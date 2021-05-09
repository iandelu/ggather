    package com.mycompany.iw.mysql;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.PartidoDAO;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisAneri
 */

public class MySQLPartidoDAO implements PartidoDAO{
    
    final String INSERT = "INSERT INTO partidos(idPartido, idCreador, idPista, idReserva, estado, nivelPartido) VALUES (?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE partidos idCreador = ? , idPista = ?, idReserva = ?, estado = ?, nivelPartido = ? WHERE idJugador = ?";
    final String DELETE = "DELETE FROM partidos WHERE idPartido = ?";
    final String GETALL = "SELECT * FROM partidos";
    final String GETONE = "SELECT * WHERE idPartido = ?";
    
    
    
    private Connection conn;
    
    public MySQLPartidoDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Partido p) throws DAOException {
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                j.setIdTarjeta(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            stat.setLong(1, p.getId());
            stat.setLong(2, p.getCreador());
            stat.setLong(3, p.getPistaPartido());
            stat.setLong(4, p.getReserva());
            stat.setString(5, p.getEstado());
            stat.setInt(6, p.getNivelPartido());
            
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
    public void modificar(Partido p) throws DAOException{

         PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, p.getIdCreador());
            stat.setLong(2, p.getPistaPartido());
            stat.setLong(3, p.getReserva);
            stat.setString(4, p.getEstado());
            stat.setInt(5, p.getNivelPartido());
            stat.setFloat(7, p.getId());

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
    public void eliminar(Partido p) throws DAOException{
        
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, p.getId());

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

    
    private Partido convertir(ResultSet rs) throws SQLException{
        
        Long creador = rs.getString("idCreador");
        Long pista = rs.getString("idPista");
        Long reserva = rs.getString("idReserva");
        String estado = rs.getString("estado");
        int nivelPartido = rs.getInt("nivelPartido");

        Partido p = new Partido(reserva, creador, pistaPartido, estado, nivelPartido);
        p.setId(rs.getLong("idPartido"));
        
        return p;
        
    }
    
    @Override
    public List<Partido> obtenerTodos() throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Partido> partidos = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               partidos.add(convertir(rs));
               
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
       
        return partidos;
    }


    @Override
    public Partido obtener(Long id) throws DAOException{
        
       PreparedStatement stat = null;
       ResultSet rs = null;
       Partido p;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               p = convertir(rs);
               
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
       
        return p;
    }
   
}
