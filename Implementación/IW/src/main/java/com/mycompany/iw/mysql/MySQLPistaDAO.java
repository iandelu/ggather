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
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Time;



/**
 *
 * @author LuisAneri
 */

public class MySQLPistaDAO implements PistaDao{
    
    private Time timeInicio = Time.valueOf(pista.getHorarioInicio());
    private Time timeFin = Time.valueOf(pista.getHorarioFin());
    
    final String INSERT = "INSERT INTO pistas(idPista, idClub, horarioInicio, horarioFin, precioHora, puntuacionMedia, idDeporte) VALUES (?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE pistas idClub = ?, horarioInicio = ?, horarioFin = ?, precioHora = ?, puntuacionMedia = ?, idDeporte = ? WHERE idPista = ?";
    final String DELETE = "DELETE FROM pistas WHERE idPista = ?";
    final String GETALL = "SELECT * FROM pistas";
    final String GETONE = "SELECT * FROM pistas WHERE idPista = ?";
    
    private Connection conn;
    
    public MySQLJugadorDAO(Connection conn) {
        
        this.conn = conn;
        
    }

    @Override
    public void insertar(Pista pista) throws DAOException   {
        
        PreparedStatement stat = null;
        
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, j.getId());
            stat.setString(2, j.getUsuario());
            stat.setString(3, j.getNombre());
            stat.setString(4, j.getEmail());
            stat.setString(5, j.getApellidos());
            stat.setDate(6, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(7, j.getContraseña());
            stat.setInt(8, j.getTelefono());
            
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
    public void modificar(Jugador j) throws DAOException{

         PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, j.getUsuario());
            stat.setString(2, j.getNombre());
            stat.setString(3, j.getEmail());
            stat.setString(4, j.getApellidos());
            stat.setDate(5, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(6, j.getContraseña());
            stat.setInt(7, j.getTelefono());
            stat.setLong(8, j.getId());
            
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
    public void eliminar(Jugador j) throws DAOException{
        
        
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

    @Override
    public void modificar(Pista pista) throws DAOException  {
        PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(UPDATE);            
            
            stat.setLong(1, pista.getClub());
            stat.setTime(2, timeInicio);
            stat.setTime(3, timeFin);
            stat.setFloat(4, pista.getPrecioHora());
            stat.setString(5, pista.getPuntuacionMedia());
            stat.setLong(6, pista.getIdDeporte());
            stat.setLong(7, pista.getId());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pista> obtenerTodos() throws DAOException  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pista obtener(Long id) throws DAOException  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
