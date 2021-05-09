/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;

import com.mycompany.iw.Club;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.daos.ClubDAO;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.JugadorDao;
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

public class MySQLClubDAO implements ClubDAO{
    
    final String INSERT = "INSERT INTO club(idClub, nombreClub, localización, email, telefono, nombrePropietario, alta, contraseña) VALUES (?,?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE club nombreClub = ? , localización = ?, email = ?, teléfono = ?, nombrePropietario = ?, alta = ?,contraseña = ? WHERE idClub = ?";
    final String DELETE = "DELETE FROM club WHERE idClub = ?";
    final String GETALL = "SELECT * FROM club";
    final String GETONE = "SELECT * FROM club WHERE idClub = ?";
    
    
    
    private Connection conn;
    
    public MySQLClubDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Club c) throws DAOException {
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, c.getId());
            stat.setString(2, c.getNombreClub());
            stat.setString(3, c.getLocalizacion());
            stat.setString(4, c.getEmail());
            stat.setLong(5, c.getTelefono());
            stat.setString(6, c.getNombrePropietario());
            stat.setBool(7, c.getAlta());
            stat.setString(8, c.getContraseña());
            
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
    public void modificar(Club c) throws DAOException{

         PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, c.getNombreClub());
            stat.setString(2, c.getLocalizacion());
            stat.setString(3, c.getEmail());
            stat.setDouble(4, c.getTelefono());
            stat.setLong(5, c.getNombrePropietario());
            stat.setBool(6,c.getAlta());
            stat.setString(7, c.getContraseña());
            stat.setLong(8, c.getIDd());
            
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
    public void eliminar(Club c) throws DAOException{
        
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, c.getId());

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

    
    private Club convertir(ResultSet rs) throws SQLException{
        
        String nombreClub = rs.getString("nombreClub");
        String localizacion = rs.getString("localizacion");
        String email = rs.getString("email");
        String contraseña = rs.getString("contraseña");
        double telefono = rs.getDouble("telefono");
        String nombrePropietario = rs.getString("nombrePropietario");
        Boolean alta = rs.getBool("alta");
        
        Club c = new Club(nombreClub, localizacion, email, contraseña, telefono, nombrePropietario, alta);
        c.setId(rs.getLong("idClub"));
        
        return c;
        
    }
    
    @Override
    public List<Club> obtenerTodos() throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Club> clubes = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               clubes.add(convertir(rs));
               
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
       
        return clubes;
    }


    @Override
    public Club obtener(Long id) throws DAOException{
        
       PreparedStatement stat = null;
       ResultSet rs = null;
       Clubes c;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               c = convertir(rs);
               
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
       
        return c;
    }
    
}
