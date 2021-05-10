/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;
        
import com.mycompany.iw.Partido;
import com.mycompany.iw.Pista;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.PistaDao;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;



/**
 *
 * @author LuisAneri
 */

public class MySQLPistaDAO implements PistaDao{
    
    final String INSERT = "INSERT INTO pistas(idClub, horarioInicio, horarioFin,puntuacionMedia, idDeporte) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE pistas SET  horarioInicio = ?, horarioFin = ?, puntuacionMedia = ?, idDeporte = ? WHERE idPista = ?";
    final String DELETE = "DELETE FROM pistas WHERE idPista = ?";
    final String GETALL = "SELECT * FROM pistas";
    final String GETONE = "SELECT * FROM pistas WHERE idPista = ?";
    
    
    private Connection conn;
    
    public MySQLPistaDAO(Connection conn) {
        
        this.conn = conn;
        
    }

    @Override
    public void insertar(Pista pista) throws DAOException   {
        PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);
            
            Time timeInicio = Time.valueOf(pista.getHorarioInicio());
            Time timeFin = Time.valueOf(pista.getHorarioFin());
           
            stat.setLong(1, pista.getClub());
            stat.setTime(2, timeInicio);
            stat.setTime(3, timeFin);
            stat.setFloat(4, pista.getPuntuacionMedia());
            stat.setLong(5, pista.getDeporte());
            
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
    public void modificar(Pista pista) throws DAOException  {
        PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(UPDATE);   
            
            Time timeInicio = Time.valueOf(pista.getHorarioInicio());
            Time timeFin = Time.valueOf(pista.getHorarioFin());
            
            stat.setTime(1, timeInicio);
            stat.setTime(2, timeFin);
            stat.setFloat(3, pista.getPuntuacionMedia());
            stat.setLong(4, pista.getDeporte());
            stat.setLong(5, pista.getId());
            
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
    public void eliminar(Pista pista) throws DAOException  {
        PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(DELETE);            
            
            stat.setLong(1, pista.getId());
            
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
    
    private Pista convertir(ResultSet rs) throws SQLException, DAOException{
        
        Long idClub = rs.getLong("idClub");
        LocalTime horarioInicio = rs.getTime("horarioInicio").toLocalTime();
        LocalTime horarioFin = rs.getTime("horarioFin").toLocalTime();
        //float precioHora = rs.getFloat("precioHora");
        float puntuacionMedia = rs.getFloat("puntuacionMedia");
        Long idDeporte = rs.getLong("idDeporte");
        Long propietario = rs.getLong("idDeporte");
        
        Pista pista = new Pista(  idDeporte,  horarioInicio,  horarioFin, puntuacionMedia,  propietario);
        pista.setId(rs.getLong("idPista"));
        
        return pista;
    }

    @Override
    public List<Pista> obtenerTodos() throws DAOException  {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Pista> pistas = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               pistas.add(convertir(rs));
               
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
       
        return pistas;
       
    }

    @Override
    public Pista obtener(Long id) throws DAOException  {
        PreparedStatement stat = null;
       ResultSet rs = null;
       Pista pista;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               pista = convertir(rs);
               
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
       
        return pista;
    }
    
    final String GETNOMBRECLUB = "SELECT c.nombreClub FROM club c, pistas p WHERE p.idClub = c.idClub AND p.idClub = ?";
    final String GETNOMBREDEPORTE = "SELECT d.nombreDeporte FROM deportes d, pistas p WHERE p.idDeporte = d.idDeporte AND p.idDeporte = ?";
    final String SEARCH = "SELECT p.idPista FROM pistas p, club c, deportes d WHERE c.localizacion = ? AND d.nombreDeporte = ?";
    final String GETMISPISTAS = "SELECT p.idPista FROM pistas p, club c WHERE p.idClub = ? AND p.idClub = c.idClub";
    
    public String getNombreClub(Pista pista) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        String nombreClub;
       
        try{
           
            stat = conn.prepareStatement(GETNOMBRECLUB);
            stat.setLong(1, pista.getId());
            
            rs = stat.executeQuery();
           if(rs.next()){
               
               nombreClub = rs.getString("nombreClub");
               
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
       
        return nombreClub;
    }
    
    public String getNombreDeporte(Pista pista) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        String nombreDeporte;
       
        try{
           
            stat = conn.prepareStatement(GETNOMBREDEPORTE);
            stat.setLong(1, pista.getId());
            
            rs = stat.executeQuery();
           if(rs.next()){
               
               nombreDeporte = rs.getString("nombreDeporte");
               
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
       
        return nombreDeporte;
    }
    
    public List<Pista> buscarPista(String localizacion, String deporte) throws DAOException  {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Pista> pistas = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(SEARCH);
           stat.setString(1, localizacion);
           stat.setString(2, deporte);
           rs = stat.executeQuery();
           while(rs.next()){
               
               pistas.add(convertir(rs));
               
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
       
        return pistas;
       
    }
    
    /**
     * Devuelve una lista de pistas con todas las pistas del club con la id que se le pasa
     * @param id
     * @return pistas
     * @throws DAOException 
     */
    public List<Pista> getMisPistas(Long id) throws DAOException  {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Pista> pistas = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETMISPISTAS);
           rs = stat.executeQuery();
           while(rs.next()){
               
               pistas.add(convertir(rs));
               
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
       
        return pistas;
       
    }
    
    
    
}
