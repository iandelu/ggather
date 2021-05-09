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
    
    public MySQLResultadoDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    
    @Override
    public void insertar(Resultado r) throws DAOException{
        PreparedStatement stat = null;
        ResultSet rs;
        try{
            
            stat = conn.prepareStatement(INSERT);
            
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                r.setIdResultado(rs.getLong(1) + 1);
            }else{
                throw new DAOException("No se pudo asignar una ID a este alumno");  
            }
            
            stat.setLong(1, r.getIdResultado());
            stat.setLong(2, r.getIdJugadorPoniente());
            stat.setLong(3, r.getPartido());
            stat.setFloat(4, r.getResultado());
            stat.setLong(5, r.getMVP());
            
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
    public void modificar(Resultado r) throws DAOException{
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, r.JugadorPoniente());
            stat.setLong(2, r.getPartido());
            stat.setString(3, r.getResultado());
            stat.setLong(4, r.getMVP());
            
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
    public void eliminar(Resultado r) throws DAOException{
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, r.getIdResultado());

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
    
    private Resultado convertir(ResultSet rs) throws SQLException{
        
        Long jugadorPoniente = rs.getLong("idJugadorPoniente");
        Long partido = rs.getLong("idPartido");
        String resultados = rs.getString("resultados");
        Long mvp = rs.getLong("mvp");
        
        Resultado r = new Resultado(Long jugadorPoniente, Long partido, String resultado, Long mvp);
        r.setIdResultado(rs.getLong("idResultados"));
        
        return r;
        
    }

    @Override
    public List<Resultado> obtenerTodos() throws DAOException{
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Resultado> resultados = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               resultados.add(convertir(rs));
               
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
       
        return resultados;
    }

    @Override
    public Resultado obtener(Long id) throws DAOException{
        PreparedStatement stat = null;
       ResultSet rs = null;
       Resultado r;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               r = convertir(rs);
               
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
       
        return r;
    }

    
    
}
