
package com.mycompany.iw.mysql;

import com.mycompany.iw.Club;
import com.mycompany.iw.daos.ClubDAO;
import com.mycompany.iw.daos.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LuisAneria
 */

public class MySQLClubDAO implements ClubDAO{
    
    final String INSERT = "INSERT INTO club(alta, contraseña, email, localizacion, nombreClub, nombrePropietario, telefono) VALUES (?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE club SET alta = ? , contraseña = ?, email = ?, localizacion = ?, nombreClub = ?, nombrePropietario = ?,telefono = ? WHERE idClub = ?";
    final String DELETE = "DELETE FROM club WHERE idClub = ?";
    final String GETALL = "SELECT * FROM club";
    final String GETONE = "SELECT * FROM club WHERE email = ? and alta = 1";
    final String GETONE2 = "SELECT * FROM club WHERE idClub = ?";
    
    
    
    private Connection conn;
    
    public MySQLClubDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Club c) throws DAOException {
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            stat.setBoolean(1, c.getAlta());
            stat.setString(2, c.getContraseña());
            stat.setString(3, c.getEmail());
            stat.setString(4, c.getLocalizacion());
            stat.setString(5, c.getNombreClub());
            stat.setString(6, c.getNombrePropietario());
            stat.setLong(7, c.getTelefono());
            
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
            stat.setBoolean(1,c.getAlta());
            stat.setString(2, c.getContraseña());
            stat.setString(3, c.getEmail());
            stat.setString(4, c.getLocalizacion());
            stat.setString(5, c.getNombreClub());
            stat.setString(6, c.getNombrePropietario());
            stat.setLong(7, c.getTelefono());
            stat.setLong(8, c.getId());
            
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
        Long telefono = rs.getLong("telefono");
        String nombrePropietario = rs.getString("nombrePropietario");
        Boolean alta = rs.getBoolean("alta");
        
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
       Club c;
       
       try{
           
           stat = conn.prepareStatement(GETONE2);
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
    
    
    public Club buscarClubPorEmail(String email) throws DAOException{
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        Club c;
        
        try{
            
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, email);
            rs = stat.executeQuery();
            if(rs.next()){
                
                c = convertir(rs);
                
            }else{
            	
                c = null;
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
