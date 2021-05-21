package com.mycompany.iw.mysql;


import com.mycompany.iw.Precio;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.PrecioDAO;
import java.sql.*;



/**
 *
 * @author LuisAneri
 */

public class MySQLPrecioDAO implements PrecioDAO{
    
    final String INSERT = "INSERT INTO precios(idClub, idDeporte, mañanaTarde, precioHora) VALUES (?,?,?,?)"; 
    final String UPDATE = "UPDATE precios SET idClub = ? , idDeporte = ?, mañanaTarde = ?, precioHora = ? WHERE idPrecio = ?";
    final String DELETE = "DELETE FROM precios WHERE idPrecio = ?";
    final String GETALL = "SELECT * FROM precios";
    final String GETONE = "SELECT * FROM precios WHERE idPrecio = ?";
    
    
    
    private Connection conn;
    
    public MySQLPrecioDAO(Connection conn) {
        
        this.conn = conn;
        
    }

    @Override
    public void insertar(Precio p) throws DAOException{
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            
         
            stat.setLong(1, p.getIdClub());
            stat.setLong(2, p.getIdDeporte());
            stat.setString(3, p.getMañanaTarde());
            stat.setFloat(4, p.getPrecioHora());

                    
            
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

    @Override
    public void modificar(Precio p) throws DAOException{
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, p.getIdClub());
            stat.setLong(2, p.getIdDeporte());
            stat.setString(3, p.getMañanaTarde());
            stat.setFloat(4, p.getPrecioHora());
            stat.setLong(5, p.getId());
            
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
    public void eliminar(Precio p) throws DAOException{
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
    
     private Precio convertir(ResultSet rs) throws SQLException{
        
        Long club = rs.getLong("idClub");
        Long deporte = rs.getLong("idDeporte");
        String mañanaTarde = rs.getString("mañanaTarde");
        float precioHora = rs.getFloat("precioHora");
        
        Precio p = new Precio( club, deporte, mañanaTarde, precioHora);
        p.setId(rs.getLong("idPrecio"));
        
        return p;
        
    }

    @Override
    public List<Precio> obtenerTodos() throws DAOException{
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Precio> precios = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               precios.add(convertir(rs));
               
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
       
        return precios;
    }

    @Override
    public Precio obtener(Long id) throws DAOException{
        PreparedStatement stat = null;
       ResultSet rs = null;
       Precio p;
       
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
       
        return p;
    }

    
    
    
    final String GETCLUBPRICES = "SELECT * FROM precios WHERE IDclub = ?";
    
    public List<Precio> obtenerTodosClub(Long id) throws DAOException{
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Precio> precios = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETCLUBPRICES);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           while(rs.next()){
               
               precios.add(convertir(rs));
               
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
       
        return precios;
    }
    
    
}