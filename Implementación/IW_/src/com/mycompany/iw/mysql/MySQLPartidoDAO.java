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
    
    final String INSERT = "INSERT INTO partidos(idCreador, idPista, idReserva, estado, nivelPartido) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE partidos SET idCreador = ? , idPista = ?, idReserva = ?, estado = ?, nivelPartido = ? WHERE idPartido = ?";
    final String DELETE = "DELETE FROM partidos WHERE idPartido = ?";
    final String GETALL = "SELECT * FROM partidos";
    final String GETONE = "SELECT * FROM partidos WHERE idPartido = ?";
    
    
    
    private Connection conn;
    
    public MySQLPartidoDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Partido p) throws DAOException {
        
        PreparedStatement stat = null;

        
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            stat.setLong(1, p.getCreador());
            stat.setLong(2, p.getPistaPartido());
            stat.setLong(3, p.getReserva());
            stat.setString(4, p.getEstado());
            stat.setInt(5, p.getNivelPartido());
            
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
            stat.setLong(1, p.getCreador());
            stat.setLong(2, p.getPistaPartido());
            stat.setLong(3, p.getReserva());
            stat.setString(4, p.getEstado());
            stat.setInt(5, p.getNivelPartido());
            stat.setFloat(6, p.getId());

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
        
        Long creador = rs.getLong("idCreador");
        Long pista = rs.getLong("idPista");
        Long reserva = rs.getLong("idReserva");
        String estado = rs.getString("estado");
        int nivelPartido = rs.getInt("nivelPartido");

        Partido p = new Partido(reserva, creador, pista, estado, nivelPartido);
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
       
        return p;
    }
   
    
    /*
    *   ------------------------------------
    *   SENTENCIAS PARA LAS TABLAS DE AMIGOS
    *   ------------------------------------
    */
    
    final String GETHISTORY = "SELECT p.idPartido, p.idCreador, p.idPista, p.idReserva, p.estado, p.nivelPartido FROM partidos p, partidos_jugador pj"
                               + "WHERE  ";
    
    /*
    *   ----------------------------------------------------------
    *   Funciones que se encargan lso partidos asociados a un Jugador
    *   ----------------------------------------------------------
    */
    
    public List<Partido> historialJugador() throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Partido> partidos = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETHISTORY);
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
    
    public void inscribirColega(String nombre, String apellidos) throws DAOException {
        
        Jugador colega = new Jugador( "COLEGA", nombre,  apellidos, "COLEGA@COLEGA.ES",  999999999);
        
                 PreparedStatement stat = null;
        
        
        try{
            
            stat = conn.prepareStatement(INSERT);   
            
            stat.setString(1, colega.getUsuario());
            stat.setString(2, colega.getNombre());
            stat.setString(3, colega.getEmail());
            stat.setString(4, colega.getApellidos());
            stat.setDate(5, new Date(colega.getFechaNacimiento().getTime()));
            stat.setString(6, colega.getContraseña());
            stat.setFloat(7, colega.getValoracionMedia()); //Esto abria que modificarlopor que al crear un usuario no posee valoracion
            stat.setLong(8, colega.getTelefono());
            
            
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
    
    
}
